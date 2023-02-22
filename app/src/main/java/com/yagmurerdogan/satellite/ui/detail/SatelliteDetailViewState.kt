package com.yagmurerdogan.satellite.ui.detail

import com.yagmurerdogan.satellite.data.model.response.PositionCoordinate
import com.yagmurerdogan.satellite.domain.model.SatelliteDetailUIModel


sealed class SatelliteDetailViewState {
    object Loading : SatelliteDetailViewState()
    class DataLoaded(val satelliteDetailUIModel: SatelliteDetailUIModel?) : SatelliteDetailViewState()
    class PositionChange(val position: PositionCoordinate?) : SatelliteDetailViewState()
    class Failure(val error: String?) : SatelliteDetailViewState()
}
