package com.magdalena.cardcollection.ui

import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi
import com.google.zxing.BarcodeFormat
import com.google.zxing.oned.Code128Writer
import com.magdalena.cardcollection.R


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayBitmap("4054613000049791038")
    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun displayBitmap(value: String) {
        val widthPixels = resources.getDimensionPixelSize(R.dimen.width_barcode)
        val heightPixels = resources.getDimensionPixelSize(R.dimen.height_barcode)


    }

    private fun createBarcodeBitmap(
            barcodeValue: String,
            @ColorInt barcodeColor: Int,
            @ColorInt backgroundColor: Int,
            widthPixels: Int,
            heightPixels: Int
    ): Bitmap {
        val bitMatrix = Code128Writer().encode(
                barcodeValue,
                BarcodeFormat.EAN_13,
                widthPixels,
                heightPixels
        )

        val pixels = IntArray(bitMatrix.width * bitMatrix.height)
        for (y in 0 until bitMatrix.height) {
            val offset = y * bitMatrix.width
            for (x in 0 until bitMatrix.width) {
                pixels[offset + x] =
                        if (bitMatrix.get(x, y)) barcodeColor else backgroundColor
            }
        }

        val bitmap = Bitmap.createBitmap(
                bitMatrix.width,
                bitMatrix.height,
                Bitmap.Config.ARGB_8888
        )
        bitmap.setPixels(
                pixels,
                0,
                bitMatrix.width,
                0,
                0,
                bitMatrix.width,
                bitMatrix.height
        )
        return bitmap
    }
}