package com.yagmurerdogan.satellite.ui.list

import com.yagmurerdogan.satellite.domain.model.SatelliteUIModel

sealed class SatelliteListViewState {
    object Loading : SatelliteListViewState()
    class ListLoaded(val list: List<SatelliteUIModel?>?) : SatelliteListViewState()
    class Failure(val errorName: String) : SatelliteListViewState()
}