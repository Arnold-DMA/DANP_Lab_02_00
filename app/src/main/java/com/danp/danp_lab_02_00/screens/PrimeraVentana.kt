package com.danp.danp_lab_02_00.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.danp.danp_lab_02_00.navigation.AppScreens
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.danp.danp_lab_02_00.R


@Composable
fun PrimeraVentana(navController: NavController){
    Scaffold(topBar = {
        TopAppBar() {
            Text(text = "PrimeraVentana")
        }
    }) {
        Contenido(navController)
    }
}

@Composable
fun Contenido(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                navController.navigate(route = AppScreens.SegundaVentana.route + "/Costa")
            },  shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.textButtonColors()) {
                Image(
                    painter = painterResource(R.drawable.ic_costa),
                    contentDescription = "Región Costa",
                    modifier = Modifier.size(192.dp)
                )
            }

            Button(onClick = {
                navController.navigate(route = AppScreens.SegundaVentana.route + "/Costa")
            }, shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.textButtonColors(),
                ) {
                Text ("Costa")
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                navController.navigate(route = AppScreens.SegundaVentana.route + "/Sierra")
            },  shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.textButtonColors()) {
                Image(
                    painter = painterResource(R.drawable.ic_sierra),
                    contentDescription = "Región Sierra",
                    modifier = Modifier.size(192.dp)
                )
            }

            Button(onClick = {
                navController.navigate(route = AppScreens.SegundaVentana.route + "/Sierra")
            }, shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.textButtonColors()
            ) {
                Text ("Sierra")
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                navController.navigate(route = AppScreens.SegundaVentana.route + "/Selva")
            },  shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.textButtonColors()) {
                Image(
                    painter = painterResource(R.drawable.ic_selva),
                    contentDescription = "Región SelvaCosta",
                    modifier = Modifier.size(192.dp)
                )
            }

            Button(onClick = {
                navController.navigate(route = AppScreens.SegundaVentana.route + "/Selva")
            }, shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.textButtonColors()
            ) {
                Text ("Selva")
            }
        }
    }
}

