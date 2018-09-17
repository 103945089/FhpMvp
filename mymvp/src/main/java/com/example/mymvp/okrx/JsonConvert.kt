package com.example.mymvp.okrx

import android.util.JsonReader
import com.google.gson.Gson
import com.lzy.okgo.convert.Converter
import okhttp3.Response
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Created by Never Fear   on 2018\9\4 0004.
 *Never More....
 *RIGHT_CODE--为后台约定的正确码标志
 *
 *此Converter只允许泛型入参
 *除RIGHT_CODE外的所有CODE都上抛自定义异常到OnError中将Throwable强转为MyException进行处理
 * 如果要更改RIGHT_CODE请在application中自行修改
 */
open class JsonConvert<T>: Converter<T> {
    private var type: Type?=null
    private var clazz:Class<T>?=null
    companion object {
        var RIGHT_CODE=200
    }
    @Throws(Throwable::class)
    override fun convertResponse(response: Response): T? {
        val genericSuperclass = javaClass.genericSuperclass
        type = (genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return pariseBean(type as Class<T>?, response)
    }

    @Throws(IOException::class, JSONException::class)
    private fun pariseBean(type: Class<T>?, response: Response): T? {
        if (type == null) return null
        val body = response.body() ?: return null
        val reader = JsonReader(body.charStream())
        if (type == String::class.java) {
            return body.string() as T
        } else if (type == JSONObject::class.java) {
            return JSONObject(body.string()) as T
        } else if (type == JSONArray::class.java) {
            return JSONArray(body.string()) as T
        } else {
            val responceStr = body.string()
            val baseBean = Gson().fromJson(responceStr, BaseBean::class.java)
            if (baseBean.code== RIGHT_CODE){
                val t = Gson().fromJson(responceStr, type)
                response.close()
                return t
            }else{
                val myException = MyException(baseBean.code, baseBean.msg)
                throw myException
            }
        }
    }
}