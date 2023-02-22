package com.yagmurerdogan.satellite.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yagmurerdogan.satellite.domain.usecase.list.SatelliteListUseCase
import com.yagmurerdogan.satellite.domain.usecase.list.SatelliteSearchUseCase
import com.yagmurerdogan.satellite.util.Constant.SATELLITE_FILE
import com.yagmurerdogan.satellite.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SatelliteListViewModel @Inject constructor(
    private val satelliteListUseCase: SatelliteListUseCase,
    private val satelliteListSearchUseCase: SatelliteSearchUseCase
) : ViewModel() {

    private val _listFlow = MutableStateFlow<SatelliteListViewState?>(null)
    val listFlow: StateFlow<SatelliteListViewState?> get() = _listFlow

    fun getSatelliteList() {
        _listFlow.value = SatelliteListViewState.Loading
        viewModelScope.launch {
            when (val satelliteList =
                satelliteListUseCase.execute(SatelliteListUseCase.Request(SATELLITE_FILE))) {
                is Resource.Success -> {
                    _listFlow.value =
                        SatelliteListViewState.ListLoaded(satelliteList.data)
                }
                is Resource.Failure -> {
                    SatelliteListViewState.Failure(satelliteList.error)
                }
            }
        }
    }

    fun makeSearch(searchKey: String) {
        _listFlow.value = SatelliteListViewState.Loading
        viewModelScope.launch {
            when (val hasSearchedList =
                satelliteListSearchUseCase.execute(
                    SatelliteSearchUseCase.Request(
                        SATELLITE_FILE,
                        searchKey
                    )
                )) {
                is Resource.Success -> {
                    _listFlow.value =
                        SatelliteListViewState.ListLoaded(hasSearchedList.data)
                }
                is Resource.Failure -> {
                    SatelliteListViewState.Failure(hasSearchedList.error)
                }
            }
        }
    }

}