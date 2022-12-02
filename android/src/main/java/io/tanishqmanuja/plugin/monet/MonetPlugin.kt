package io.tanishqmanuja.plugin.monet

import android.os.Build
import com.getcapacitor.JSObject
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin
import com.google.gson.Gson

@CapacitorPlugin(name = "Monet")
class MonetPlugin : Plugin() {
    private val implementation = Monet()

    @PluginMethod
    fun generateMonetPalette(call: PluginCall) {
        val clr = call.getString("seedColor")
        val palette = implementation.generateMonetPalette(clr!!)
        val jsonString = Gson().toJson(palette)
        val ret = JSObject(jsonString)
        call.resolve(ret)
    }

    @PluginMethod
    fun getSystemMonetPalette(call: PluginCall) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            return call.resolve()
        }
        val palette = implementation.getSystemMonetPalette(this.context)
        val jsonString = Gson().toJson(palette)
        val ret = JSObject(jsonString)
        call.resolve(ret)
    }
}