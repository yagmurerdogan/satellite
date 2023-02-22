package com.yagmurerdogan.satellite.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yagmurerdogan.satellite.data.model.entity.SatellitePosition
import com.yagmurerdogan.satellite.domain.usecase.detail.GetSatelliteUIUseCase
import com.yagmurerdogan.satellite.util.Constant.POSITION_CHANGE_DELAY
import com.yagmurerdogan.satellite.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SatelliteDetailViewModel @Inject constructor(
    private val getSatelliteUIUseCase: GetSatelliteUIUseCase
) : ViewModel() {

    private val _satelliteDetailFlow =
        MutableStateFlow<SatelliteDetailViewState?>(null)
    val satelliteDetailFlow: StateFlow<SatelliteDetailViewState?> get() = _satelliteDetailFlow

    fun getSatelliteDetail(satelliteId: Int) {
        _satelliteDetailFlow.value = SatelliteDetailViewState.Loading
        viewModelScope.launch {
            when (val satelliteUIModel =
                getSatelliteUIUseCase.execute(GetSatelliteUIUseCase.Request(satelliteId))) {
                is Resource.Success -> {
                    _satelliteDetailFlow.value =
                        SatelliteDetailViewState.DataLoaded(satelliteUIModel.data)
                }
                is Resource.Failure -> {
                    _satelliteDetailFlow.value =
                        SatelliteDetailViewState.Failure(satelliteUIModel.error)
                }
            }
        }
    }

    fun changePosition(list: List<SatellitePosition?>?) {
        viewModelScope.launch {
            val positions = list?.get(0)?.positions
            for (i in 1 until positions!!.size) {
                delay(POSITION_CHANGE_DELAY)
                _satelliteDetailFlow.value = SatelliteDetailViewState.PositionChange(positions[i])
            }
        }
    }
}