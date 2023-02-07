package com.example.myapplication.screenui

import android.net.Uri
import android.os.Environment
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.myapplication.R
import com.example.myapplication.ui.theme.*
import com.example.myapplication.viewmodels.ImageUpdateViewModel
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File


@Composable
fun ToxScreen( imageUpdateViewModel: ImageUpdateViewModel = hiltViewModel()) {

    var inputext by remember {
        mutableStateOf("")
    }

    var selectedImage by remember {
        mutableStateOf<Uri?>(null)
    }
    val ctx = LocalContext.current

    val stateUpdateImage = imageUpdateViewModel._getUserStateFlow.collectAsState()

    val launcher = rememberLauncherForActivityResult(contract =
    ActivityResultContracts.GetContent()) { uri: Uri? ->
        selectedImage = uri
    }


Column(modifier = Modifier
    .fillMaxWidth()
    .fillMaxHeight(0.93f)
    .padding(vertical = 8.dp, horizontal = 8.dp),
    verticalArrangement = Arrangement.SpaceBetween
) {


    //Create own text editor in kotlin
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Text(text = stateUpdateImage.value.toString())
        Box(modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, cgraylight)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), verticalAlignment = Alignment.CenterVertically)
            {


                Image(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.cinlogolarge),
                    alignment = Alignment.CenterStart,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column() {
                    Text(text ="CryptoxIN", style = TextStyle(color = chonolulublue, fontSize = 20.sp))
                    Text(text = "@prvks", style = TextStyle(color = cgraystrong, fontSize = 14.sp))
                }
            }
        }
       TextField(
            value = inputext,
           placeholder = { Text(text = "What do you want to talk about")},
           modifier = Modifier
               .fillMaxWidth()
               .border(
                   BorderStroke(
                       width = 0.dp,
                       color = Color.Black
                   ),
               ),
           colors = TextFieldDefaults.textFieldColors(
               backgroundColor = Color.Transparent,
               focusedIndicatorColor = Color.Transparent,
               unfocusedIndicatorColor = Color.Transparent
           ),
           textStyle = TextStyle(fontSize = 18.sp),
            onValueChange = {
            inputext = it
        })

        //Image slider jetpack compose
        Row(modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .height(200.dp)
            .fillMaxWidth()
        ) {
            if (selectedImage!=null) {
                Box(modifier = Modifier.size(200.dp)) {
                    Image(painter = rememberAsyncImagePainter(selectedImage),
                        contentDescription = "Profile",
                        contentScale = ContentScale.Crop
                    )
                }

            }
        }


    }


    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {


        Column() {
            Text("# Add Hashtag",style = TextStyle(color = cgreenlight, fontSize = 20.sp))
            Row() {
                Icon(
                    painter = painterResource(id = R.drawable.ic_outline_add_photo_alternate_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .padding(start = 8.dp)
                        .clickable {
                            launcher.launch("image/*")
                        },
                    tint = chonolulublue
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_round_videocam_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .padding(start = 8.dp),
                    tint = chonolulublue
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_outline_bar_chart_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .padding(start = 8.dp),
                    tint = chonolulublue
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_outline_text_fields_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .padding(start = 8.dp),
                    tint = chonolulublue
                )


            }
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_send_24),
            contentDescription = null,
            tint = chonolulublue,
            modifier = Modifier
                .size(48.dp)
                .padding(start = 8.dp).clickable{
                //ImageUpdate

                val path: File = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_PICTURES
                )

                    val name= getRandomString(16)
                    Log.e("1111",name)
                val files = File(path, "$name.jpg")


                try {
                    if (!path.isDirectory()) {
                        path.mkdirs()
                    }
                    files.createNewFile()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                    Log.e("2222",files.toString())
                files.outputStream().use {
            ctx.contentResolver.openInputStream(selectedImage!!)?.copyTo(it)
                }

                    Log.d("2222",files.toString())
                ///
                val requestFile = files.asRequestBody("image/*".toMediaTypeOrNull())
                val file = MultipartBody.Part.createFormData("file", files.name, requestFile)

                val myAddress =
                    "0x5Ac32b12daF2D5942403D3fc97f168Fa485C795C".toRequestBody("text/plain".toMediaTypeOrNull())
                val privateKey ="6a9cdaafc795b70dd6e700502de3d37d7dd77c1fb76198eff77a270d1c412a77".toRequestBody("text/plain".toMediaTypeOrNull())

                val type =
                    "3".toRequestBody("text/plain".toMediaTypeOrNull())
                val _hashtag =
                    "1dsd".toRequestBody("text/plain".toMediaTypeOrNull())
                val _content =
                    "165".toRequestBody("text/plain".toMediaTypeOrNull())


                imageUpdateViewModel.getImageUpdateCall(
                    file,
                    myAddress,
                    privateKey,
                    type,
                    _content,
                    _hashtag
                )

                Log.e("1111",stateUpdateImage.value.toString())

            },
        )

    }




}



}



fun getRandomString(length: Int) : String {
    val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
    return (1..length)
        .map { allowedChars.random() }
        .joinToString("")
}