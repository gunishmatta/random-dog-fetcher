package com.gunish.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import coil.api.load
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_get_image.setOnClickListener {
            launch(Dispatchers.Main)
            {
                try {
                    val response=ApiAdapter.apiClient.getRandomDogImage()
                    if(response.isSuccessful&&response.body()!=null)
                    {
                        val data=response.body()!!
                        data.message?.let {
                            imageUrl->iv_dog_image.load(imageUrl)
                        }
                    }
                    else{
                        Toast.makeText(this@MainActivity,  "Error Occurred: ${response.message()}",Toast.LENGTH_LONG).show()
                    }
                }
                catch (e:Exception)
                {
            Toast.makeText(this@MainActivity,"Error Message ${e.message}",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}