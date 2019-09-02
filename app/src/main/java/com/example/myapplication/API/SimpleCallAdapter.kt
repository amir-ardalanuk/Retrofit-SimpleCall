package com.example.myapplication.API

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class SimpleCallAdapter<R>(private val responseType: Type ):CallAdapter<R,Any>{

    override fun responseType(): Type = responseType

    override fun adapt(call: Call<R>): Any = Simple(call)
}

class SimpleCallAdapterFactory private constructor() : CallAdapter.Factory() {

    override fun get(returnType: Type?, annotations: Array<out Annotation>?, retrofit: Retrofit?): CallAdapter<*, *>? {
        return returnType?.let {

            return try {
                // get enclosing type
                val enclosingType = (it as ParameterizedType)

                // ensure enclosing type is 'Simple'
                if (enclosingType.rawType != Simple::class.java)
                    null
                else {
                    val type = enclosingType.actualTypeArguments[0]

                    SimpleCallAdapter<Any>(type)
                }
            } catch (ex: ClassCastException) {
                null
            }
        }
    }

    companion object {
        @JvmStatic
        fun create() = SimpleCallAdapterFactory()
    }

}