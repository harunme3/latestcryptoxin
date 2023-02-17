package com.example.myapplication.screenui.profilescreen

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplication.data.models.profilem.ProfileM
import com.example.myapplication.ui.theme.cgraylight
import com.example.myapplication.ui.theme.cgraystronglight
import com.example.myapplication.ui.theme.chonolulublue
import com.example.myapplication.ui.theme.cyellow
import com.example.myapplication.uistate.ProfileS
import com.example.myapplication.viewmodels.ImageUpdateViewModel
import com.example.myapplication.viewmodels.ProfileUpdateVM
import com.example.myapplication.viewmodels.ProfileVM


@Composable
fun EditProfile(navController: NavController, profileVM: ProfileVM= hiltViewModel()) {

    val profileState = profileVM._getProfileStateFlow.collectAsState()
    Log.e("1111" , profileState.value.toString())


    when (profileState.value) {
        is ProfileS.Empty -> {
            Column(
                modifier = Modifier.fillMaxSize() ,
                verticalArrangement = Arrangement.Center ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.then(Modifier.size(32.dp)) ,
                    color = cyellow

                )
            }
        }
        is ProfileS.Loading -> {
            Column(
                modifier = Modifier.fillMaxSize() ,
                verticalArrangement = Arrangement.Center ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.then(Modifier.size(64.dp)) ,
                    color = chonolulublue
                )
            }
        }
        is ProfileS.Error -> Text(text = "error")
        is ProfileS.Loaded -> {
            val profileStateData = (profileState.value as ProfileS.Loaded).data


            EditProfileComponent(navController,profileStateData)

        }


    }


}


@Composable
fun EditProfileComponent(
    navController: NavController,
    data: ProfileM ,
    imageUpdateViewModel: ImageUpdateViewModel = hiltViewModel() ,
profileUpdateVM: ProfileUpdateVM= hiltViewModel()
) {

    val profileUpdateVMState = profileUpdateVM._setProfileUpdateStateFlow.collectAsState()
    Log.e("2222",profileUpdateVMState.value.toString())

    //===================*************+++++++++++++++++++++++
    //data
    var name by remember { mutableStateOf(TextFieldValue(data.data.Name)) }
    var email by remember { mutableStateOf(TextFieldValue(data.data.MailID)) }
    var organization by remember { mutableStateOf(TextFieldValue(data.data.Organization)) }
    var profileTag by remember { mutableStateOf(TextFieldValue(data.data.ProfileTag)) }
    var designation by remember { mutableStateOf(TextFieldValue(data.data.designation)) }
    var dob by remember { mutableStateOf(TextFieldValue(data.data.Dobss)) }
    var otherDetails by remember { mutableStateOf(TextFieldValue(data.data.Otherdetail)) }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(horizontal = 16.dp),
            ) {

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
               profileUpdateVM.setProfileUpdate(name.text,data.data.UserName,email.text,organization.text,profileTag.text,designation.text,dob.text,otherDetails.text,data.data.Profileimgg,data.data.backgroundimgg)
                            }
                        )
                        {
                            Box(
                                modifier = Modifier
                                    .background(
                                        Brush.horizontalGradient(
                                            listOf(
                                                Color(0xFF0e4869) ,
                                                Color(0xFF175c87) ,
                                                Color(0xFF2470a6) ,
                                                Color(0xFF3385c6) ,
                                                Color(0xFF459ae7) ,
                                            ) ,
                                        ) ,
                                    )
                                    .padding(horizontal = 18.dp , vertical = 8.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "Save", color = Color.White)
                            }
                        }

                    }

                }


                Column() {
                    Box(modifier = Modifier.height(50.dp))
                    Column() {

                        Text(text = "Name", color = cgraystronglight)
                        BasicTextField(value = name,
                            onValueChange = {
                                     name=it
                            },
                            textStyle = TextStyle(fontWeight = FontWeight.Bold,
                                fontSize = 16.sp))
                    }
                    Divider(modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp))
                }
                Column() {
                    Box(modifier = Modifier.height(10.dp))
                    Column() {
                        Text(text = "Email", color = cgraylight)
                        BasicTextField(value = email,
                            onValueChange = {
                                email=it
                            },
                            textStyle = TextStyle(fontWeight = FontWeight.Bold,
                                fontSize = 16.sp))
                    }
                    Divider(modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp))
                }
                Column() {
                    Box(modifier = Modifier.height(10.dp))
                    Column() {

                        Text(text = "Organization", color = cgraylight)
                        BasicTextField(value = organization,
                            onValueChange = {
                                organization=it
                            },
                            textStyle = TextStyle(fontWeight = FontWeight.Bold,
                                fontSize = 16.sp))
                    }
                    Divider(modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp))
                }
                Column() {
                    Box(modifier = Modifier.height(10.dp))
                    Column() {
                        Text(text = "Profile #Tag", color = cgraystronglight)
                        BasicTextField(value = profileTag,
                            onValueChange = {
                                profileTag=it
                            },
                            textStyle = TextStyle(fontWeight = FontWeight.Bold,
                                fontSize = 16.sp))
                    }
                    Divider(modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp))
                }
                Column() {
                    Box(modifier = Modifier.height(10.dp))
                    Column() {
                        Text(text = "Designation", color = cgraystronglight)
                        BasicTextField(value = designation,
                            onValueChange = {
                                designation=it
                            },
                            textStyle = TextStyle(fontWeight = FontWeight.Bold,
                                fontSize = 16.sp))
                    }
                    Divider(modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp))
                }

                Column() {
                    Box(modifier = Modifier.height(10.dp))
                    Column() {
                        Text(text = "Date of Birth", color = cgraystronglight)
                        BasicTextField(value = dob,       onValueChange = {
                            dob=it
                        }, textStyle = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp))
                    }
                    Divider(modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp))
                }
                Column() {
                    Box(modifier = Modifier.height(10.dp))
                    Column() {
                        Text(text = "Other details", color = cgraylight)
                        BasicTextField(value = otherDetails,
                            onValueChange = {
                                otherDetails=it
                            },
                            textStyle = TextStyle(fontWeight = FontWeight.Bold,
                                fontSize = 16.sp))
                    }
                    Divider(modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp))
                }
            }
}





