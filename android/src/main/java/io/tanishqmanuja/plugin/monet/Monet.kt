package io.tanishqmanuja.plugin.monet

import android.content.Context
import android.graphics.Color.parseColor
import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.google.gson.annotations.SerializedName
import com.kyant.monet.TonalPalette
import com.kyant.monet.TonalPalettes
import com.kyant.monet.TonalPalettes.Companion.toTonalPalettes
import androidx.core.content.ContextCompat.getColor

class Monet {
    fun generateMonetPalette(seedColor: String): Any {
        val clr = Color(parseColor(seedColor))
        val tp = clr.toTonalPalettes()
        return parsePalette((tp))
    }

    fun getSystemMonetPalette(context: Context): Any {
        val a1p = MonetTonalPalette(
            getColor(context, android.R.color.system_accent1_0).toHex(),
            getColor(context, android.R.color.system_accent1_10).toHex(),
            getColor(context, android.R.color.system_accent1_50).toHex(),
            getColor(context, android.R.color.system_accent1_100).toHex(),
            getColor(context, android.R.color.system_accent1_200).toHex(),
            getColor(context, android.R.color.system_accent1_300).toHex(),
            getColor(context, android.R.color.system_accent1_400).toHex(),
            getColor(context, android.R.color.system_accent1_500).toHex(),
            getColor(context, android.R.color.system_accent1_600).toHex(),
            getColor(context, android.R.color.system_accent1_700).toHex(),
            getColor(context, android.R.color.system_accent1_800).toHex(),
            getColor(context, android.R.color.system_accent1_900).toHex(),
            getColor(context, android.R.color.system_accent1_1000).toHex(),
        )
        val a2p = MonetTonalPalette(
            getColor(context, android.R.color.system_accent2_0).toHex(),
            getColor(context, android.R.color.system_accent2_10).toHex(),
            getColor(context, android.R.color.system_accent2_50).toHex(),
            getColor(context, android.R.color.system_accent2_100).toHex(),
            getColor(context, android.R.color.system_accent2_200).toHex(),
            getColor(context, android.R.color.system_accent2_300).toHex(),
            getColor(context, android.R.color.system_accent2_400).toHex(),
            getColor(context, android.R.color.system_accent2_500).toHex(),
            getColor(context, android.R.color.system_accent2_600).toHex(),
            getColor(context, android.R.color.system_accent2_700).toHex(),
            getColor(context, android.R.color.system_accent2_800).toHex(),
            getColor(context, android.R.color.system_accent2_900).toHex(),
            getColor(context, android.R.color.system_accent2_1000).toHex(),
        )
        val a3p = MonetTonalPalette(
            getColor(context, android.R.color.system_accent3_0).toHex(),
            getColor(context, android.R.color.system_accent3_10).toHex(),
            getColor(context, android.R.color.system_accent3_50).toHex(),
            getColor(context, android.R.color.system_accent3_100).toHex(),
            getColor(context, android.R.color.system_accent3_200).toHex(),
            getColor(context, android.R.color.system_accent3_300).toHex(),
            getColor(context, android.R.color.system_accent3_400).toHex(),
            getColor(context, android.R.color.system_accent3_500).toHex(),
            getColor(context, android.R.color.system_accent3_600).toHex(),
            getColor(context, android.R.color.system_accent3_700).toHex(),
            getColor(context, android.R.color.system_accent3_800).toHex(),
            getColor(context, android.R.color.system_accent3_900).toHex(),
            getColor(context, android.R.color.system_accent3_1000).toHex(),
        )

        val n1p = MonetTonalPalette(
            getColor(context, android.R.color.system_neutral1_0).toHex(),
            getColor(context, android.R.color.system_neutral1_10).toHex(),
            getColor(context, android.R.color.system_neutral1_50).toHex(),
            getColor(context, android.R.color.system_neutral1_100).toHex(),
            getColor(context, android.R.color.system_neutral1_200).toHex(),
            getColor(context, android.R.color.system_neutral1_300).toHex(),
            getColor(context, android.R.color.system_neutral1_400).toHex(),
            getColor(context, android.R.color.system_neutral1_500).toHex(),
            getColor(context, android.R.color.system_neutral1_600).toHex(),
            getColor(context, android.R.color.system_neutral1_700).toHex(),
            getColor(context, android.R.color.system_neutral1_800).toHex(),
            getColor(context, android.R.color.system_neutral1_900).toHex(),
            getColor(context, android.R.color.system_neutral1_1000).toHex(),
        )

        val n2p = MonetTonalPalette(
            getColor(context, android.R.color.system_neutral2_0).toHex(),
            getColor(context, android.R.color.system_neutral2_10).toHex(),
            getColor(context, android.R.color.system_neutral2_50).toHex(),
            getColor(context, android.R.color.system_neutral2_100).toHex(),
            getColor(context, android.R.color.system_neutral2_200).toHex(),
            getColor(context, android.R.color.system_neutral2_300).toHex(),
            getColor(context, android.R.color.system_neutral2_400).toHex(),
            getColor(context, android.R.color.system_neutral2_500).toHex(),
            getColor(context, android.R.color.system_neutral2_600).toHex(),
            getColor(context, android.R.color.system_neutral2_700).toHex(),
            getColor(context, android.R.color.system_neutral2_800).toHex(),
            getColor(context, android.R.color.system_neutral2_900).toHex(),
            getColor(context, android.R.color.system_neutral2_1000).toHex(),
        )

        return MonetPalette(a1p,a2p,a3p,n1p,n2p)
    }
}

private data class MonetPalette(
    var accent1: MonetTonalPalette,
    var accent2: MonetTonalPalette,
    var accent3: MonetTonalPalette,
    var neutral1: MonetTonalPalette,
    var neutral2: MonetTonalPalette
)

private data class MonetTonalPalette(
    @SerializedName("0") var s1: String,
    @SerializedName("10") var s2: String,
    @SerializedName("50") var s3: String,
    @SerializedName("100") var s4: String,
    @SerializedName("200") var s5: String,
    @SerializedName("300") var s6: String,
    @SerializedName("400") var s7: String,
    @SerializedName("500") var s8: String,
    @SerializedName("600") var s9: String,
    @SerializedName("700") var s10: String,
    @SerializedName("800") var s11: String,
    @SerializedName("900") var s12: String,
    @SerializedName("1000") var s14: String,
)

fun <T : Any> T.getPrivateProperty(variableName: String): Any? {
    return javaClass.getDeclaredField(variableName).let { field ->
        field.isAccessible = true
        return@let field.get(this)
    }
}

private fun parsePalette(palettes: TonalPalettes): MonetPalette {
    val a1 = palettes.getPrivateProperty("accent1")
    val a2 = palettes.getPrivateProperty("accent2")
    val a3 = palettes.getPrivateProperty("accent3")
    val n1 = palettes.getPrivateProperty("neutral1")
    val n2 = palettes.getPrivateProperty("neutral2")

    @Suppress("UNCHECKED_CAST")
    val a1p = parseTonalPalette(a1 as TonalPalette)

    @Suppress("UNCHECKED_CAST")
    val a2p = parseTonalPalette(a2 as TonalPalette)

    @Suppress("UNCHECKED_CAST")
    val a3p = parseTonalPalette(a3 as TonalPalette)

    @Suppress("UNCHECKED_CAST")
    val n1p = parseTonalPalette(n1 as TonalPalette)

    @Suppress("UNCHECKED_CAST")
    val n2p = parseTonalPalette(n2 as TonalPalette)

    return MonetPalette(a1p, a2p, a3p, n1p, n2p)
}

private fun parseTonalPalette(p: TonalPalette): MonetTonalPalette {
    return MonetTonalPalette(
        // skips the first value
        // p.values.elementAt(13).toHex(),
        p.values.elementAt(12).toHex(),
        p.values.elementAt(11).toHex(),
        p.values.elementAt(10).toHex(),
        p.values.elementAt(9).toHex(),
        p.values.elementAt(8).toHex(),
        p.values.elementAt(7).toHex(),
        p.values.elementAt(6).toHex(),
        p.values.elementAt(5).toHex(),
        p.values.elementAt(4).toHex(),
        p.values.elementAt(3).toHex(),
        p.values.elementAt(2).toHex(),
        p.values.elementAt(1).toHex(),
        p.values.elementAt(0).toHex()
    )
}

private fun Color.toHex(): String {
    val intColor = this.toArgb()
    return intColor.toHex()
}

private fun Int.toHex() = String.format("#%06X", 0xFFFFFF and this)