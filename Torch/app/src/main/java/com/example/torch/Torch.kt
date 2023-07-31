package com.example.torch

import android.content.Context
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager

class Torch (context: Context) {
    private var cameraId: String? = null
    private val cameraManger = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager

    init{
        cameraId = getCameraId()
    }
    fun flashOn() {
        cameraId?.let { cameraManger.setTorchMode(it, true) }
    }

    fun flashOff() {
        cameraId?.let { cameraManger.setTorchMode(it, false) }
    }

    private fun getCameraId(): String? {
        val camaraIds = cameraManger.cameraIdList
        for (id in camaraIds) {
            val info = cameraManger.getCameraCharacteristics(id)
            val flashAvailable = info.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)
            val lensFacing = info.get(CameraCharacteristics.LENS_FACING)
            if (flashAvailable != null && flashAvailable
                && lensFacing != null && lensFacing == CameraCharacteristics.LENS_FACING_BACK
            ) {
                return id
            }
        }
        return null
    }
}