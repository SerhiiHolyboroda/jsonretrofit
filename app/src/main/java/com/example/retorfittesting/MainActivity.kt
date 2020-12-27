package com.example.retorfittesting
import android.os.Bundle
import android.widget.TextView
import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.Call;
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class factList {
    @SerializedName("items")
    var facts: List<Facts>? = null
}
data class Facts(
    var type: String,
    var deleted: Boolean,
    var _id: String,
    var user: String,
    var text: String,
    var __v: Int,
    var source: String,
    var updatedAt: String,
    var createdAt: String,
    var used: Boolean,
)
interface Api {
     
    @get:GET("facts")
    val facts: Call<factList?>?
}
fun main() {
    val BASE_URL = "https://cat-fact.herokuapp.com/"
    var tv_user: TextView? = null
    var str:String = ""

    // function to call server and update ui
    fun getFacts() {

        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
//

        var api = retrofit.create(Api::class.java)
        var call = api.facts

        call?.enqueue(object : Callback<factList> {
            //

            override fun onResponse(call: Call<factList>, response: Response<factList>) {

                var  facts = response?.body()
                println(facts)


        }
  override fun onFailure(call: Call<factList>, t: Throwable) {

    println("Ooops")
}
            })
    }


}

private fun Any?.enqueue(callback: Callback<factList>) {

}
