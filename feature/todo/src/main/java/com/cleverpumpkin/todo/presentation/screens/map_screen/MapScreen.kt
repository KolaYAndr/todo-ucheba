package com.cleverpumpkin.todo.presentation.screens.map_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.layers.GeoObjectTapListener
import com.yandex.mapkit.mapview.MapView

@Composable
fun MapScreen(
    onNavBack: () -> Unit,
    onSave: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val mapViewRef = remember { mutableStateOf<MapView?>(null) }
    val tapListener = GeoObjectTapListener { event ->
        onSave(event.geoObject.name.orEmpty())
        onNavBack()
        true
    }

    AndroidView(
        modifier = modifier,
        factory = { ctx ->

            MapView(ctx).apply {
                mapViewRef.value = this
                mapWindow.map.addTapListener(tapListener)
            }
        }
    )

    mapViewRef.value?.let { mapView ->
        DisposableEffect(mapView) {
            MapKitFactory.getInstance().onStart()
            mapView.onStart()

            onDispose {
                mapView.onStop()
                MapKitFactory.getInstance().onStop()
            }
        }
    }
}
