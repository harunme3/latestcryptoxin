package com.example.myapplication.screenui.profilescreen

import android.content.Context
import android.net.Uri
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.myapplication.R
import com.example.myapplication.data.datasource.remotedata.ImageUpdateInterface
import com.example.myapplication.data.datasource.remotedata.TestInterface
import com.example.myapplication.data.models.imageupdatemodel.ImageUpdateModel
import com.example.myapplication.ui.theme.cgraylight
import com.example.myapplication.ui.theme.cgraystronglight
import com.example.myapplication.viewmodels.ImageUpdateViewModel
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File


@Composable
fun EditProfile( imageUpdateViewModel: ImageUpdateViewModel= hiltViewModel()){

    val ctx = LocalContext.current

    val stateUpdateImage = imageUpdateViewModel._getUserStateFlow.collectAsState()


    var selectedImage by remember {
        mutableStateOf<Uri?>(null)
    }




    val launcher = rememberLauncherForActivityResult(contract =
     ActivityResultContracts.GetContent()) { uri: Uri? ->
        selectedImage = uri
     }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(horizontal = 16.dp),
            ) {

                Text(text = stateUpdateImage.value.toString())

                Box(modifier = Modifier.fillMaxHeight(0.05f)) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment= Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()) {

                        Text(text = "Edit Profile",  fontSize = 22.sp)
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent
                            ),
                            contentPadding = PaddingValues(),
                            onClick = {
                                //ImageUpdate

                                val path: File = Environment.getExternalStoragePublicDirectory(
                                    Environment.DIRECTORY_PICTURES
                                )
                                val files = File(path, "2.jpg")

                                try {
                                    if (!path.isDirectory()) {
                                        path.mkdirs()
                                    }
                                    files.createNewFile()
                                } catch (e: Exception) {
                                    e.printStackTrace()
                                }

                                files.outputStream().use {
//                                          ctx.assets.open("image.jpg").copyTo(it)
                                    ctx.contentResolver.openInputStream(selectedImage!!)?.copyTo(it)
                                }


                                ///
                                val requestFile = files.asRequestBody("image/*".toMediaTypeOrNull())
                                val file = MultipartBody.Part.createFormData("file", files.name, requestFile)

                                val myAddress =
                                    "0x5Ac32b12daF2D5942403D3fc97f168Fa485C795C".toRequestBody("text/plain".toMediaTypeOrNull())
                                val privateKey ="6a9cdaafc795b70dd6e700502de3d37d7dd77c1fb76198eff77a270d1c412a77".toRequestBody("text/plain".toMediaTypeOrNull())

                                val type =
                                    "1".toRequestBody("text/plain".toMediaTypeOrNull())
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
                        {
                            Box(
                                modifier = Modifier
                                    .background(
                                        Brush.horizontalGradient(
                                            listOf(
                                                Color(0xFF0e4869),
                                                Color(0xFF175c87),
                                                Color(0xFF2470a6),
                                                Color(0xFF3385c6),
                                                Color(0xFF459ae7),
                                            ),
                                        ),
                                    )
                                    .padding(horizontal = 18.dp, vertical = 8.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "Save", color = Color.White)
                            }
                        }

                    }

                }

                ConstraintLayout(
                ) {

                    val camera = createRef()
                    Box(modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .clickable {
                            launcher.launch("image/*")
                        }
                     ) {
                      if (selectedImage!=null) {
                          Log.d("1111",selectedImage.toString())

                          Image(painter = rememberAsyncImagePainter(selectedImage),
                              contentDescription = "Profile",
                              contentScale = ContentScale.Crop,
                              modifier = Modifier
                                  .fillMaxSize()
                                  .clip(CircleShape))
                      }
                        else {
                          Image(painter = painterResource(R.drawable.profile),
                              contentDescription = "Profile",
                              contentScale = ContentScale.Crop,
                              modifier = Modifier
                                  .fillMaxSize()
                                  .clip(CircleShape))
                      }
                    }
                    Box(modifier = Modifier
                        .size(28.dp)
                        .clip(CircleShape)
                        .background(color = cgraystronglight)
                        .constrainAs(camera) {
                            end.linkTo(camera.end)
                        }) {
                        Image(painter = painterResource(R.drawable.ic_baseline_edit_24),
                            contentDescription = "Camera",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(4.dp)
                                .clip(CircleShape))
                    }


                }


                Column() {
                    Box(modifier = Modifier.height(50.dp))
                    Column() {

                        Text(text = "Name", color = cgraystronglight)
                        BasicTextField(value = "Priyanka Jain",
                            onValueChange = {},
                            textStyle = TextStyle(fontWeight = FontWeight.Bold,
                                fontSize = 16.sp))
                    }
                    Divider(modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp))
                }
                Column() {
                    Box(modifier = Modifier.height(10.dp))
                    Column() {
                        Text(text = "Email", color = cgraylight)
                        BasicTextField(value = "Priynka@gmail.com",
                            onValueChange = {},
                            textStyle = TextStyle(fontWeight = FontWeight.Bold,
                                fontSize = 16.sp))
                    }
                    Divider(modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp))
                }
                Column() {
                    Box(modifier = Modifier.height(10.dp))
                    Column() {

                        Text(text = "Organization", color = cgraylight)
                        BasicTextField(value = "CryptoxIN",
                            onValueChange = {},
                            textStyle = TextStyle(fontWeight = FontWeight.Bold,
                                fontSize = 16.sp))
                    }
                    Divider(modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp))
                }
                Column() {
                    Box(modifier = Modifier.height(10.dp))
                    Column() {
                        Text(text = "Profile #Tag", color = cgraystronglight)
                        BasicTextField(value = "Priyanka Jain",
                            onValueChange = {},
                            textStyle = TextStyle(fontWeight = FontWeight.Bold,
                                fontSize = 16.sp))
                    }
                    Divider(modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp))
                }
                Column() {
                    Box(modifier = Modifier.height(10.dp))
                    Column() {
                        Text(text = "Designation", color = cgraystronglight)
                        BasicTextField(value = "Kuchh nhi",
                            onValueChange = {},
                            textStyle = TextStyle(fontWeight = FontWeight.Bold,
                                fontSize = 16.sp))
                    }
                    Divider(modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp))
                }
                Column() {
                    Box(modifier = Modifier.height(10.dp))
                    Column() {
                        Text(text = "Gender", color = cgraylight)
                        BasicTextField(value = "Female", onValueChange = {}, textStyle = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp))
                    }
                    Divider(modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp))
                }
                Column() {
                    Box(modifier = Modifier.height(10.dp))
                    Column() {
                        Text(text = "Date of Birth", color = cgraystronglight)
                        BasicTextField(value = "10/08/1998", onValueChange = {}, textStyle = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp))
                    }
                    Divider(modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp))
                }
            }
}





