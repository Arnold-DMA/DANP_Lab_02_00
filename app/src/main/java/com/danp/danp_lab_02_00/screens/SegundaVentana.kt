package com.danp.danp_lab_02_00.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.danp.danp_lab_02_00.R



private val listaCosta: List<MyMessage> = listOf(
    MyMessage("Tallarines Verdes","Estos ricos tallarines en salsa verde  son una muestra de la creatividad dada a nuestra cultura por las comunidades extranjeras llegadas al país por un futuro mejor", R.drawable.ic_tallarines_verdes),
    MyMessage("Locro de Zapallo", "Esta es una receta ancestral, traída de la costa norteña del Perú. En sus principales ingredientes se pueden conseguir las papas y el zapallo, los cuales son autóctonos del país.", R.drawable.ic_locro_zapallo),
    MyMessage("Lomo Saltado", "El Lomo saltado es uno de los platos principales y más importante de todo el Perú, pues en el se encuentra una representación de nuestra cultura gastronómica .", R.drawable.ic_lomo_saltado),
    MyMessage("Cau Cau", "Este plato es uno de los más populares e importantes. Su característico color amarillo y un delicioso olor a hierbas le hacen infaltable para cualquier menú en todo el Perú.", R.drawable.ic_caucau),
    MyMessage("Picante de Mariscos", "Este rico plato del que te hablamos es fruto de ello. Siendo emblema de nuestra gastronomía, el picante de mariscos se caracteriza por tener entre sus ingredientes varios tipos de ajíes autóctonos.", R.drawable.ic_picante_mariscos),
    MyMessage("Ceviche de Pescado", "Este delicioso plato a base de pescado, limones, cebollas, ajíes y culantro tiene tantas formas de prepararse para darle nuestro toque nacional que lo hace único e inigualable.", R.drawable.ic_ceviche),
    MyMessage("Causa Limeña", "La causa rellena es uno de los platos tradicionales más importantes de la cocina peruana. Cuenta la historia que este plato era consumido desde la época precolombina, donde era una masa mezclada con ají amarillo", R.drawable.ic_causa),
    MyMessage("Tallarín Saltado Criollo", "El Tallarín Saltado Criollo es uno de esos platos la gastronomía peruana tiene que agradecer a la cocina oriental china, que es muy popular por su increíble sabor.", R.drawable.ic_tallarin_saltado),
    MyMessage("Chilcano de Pescado", "Esta popular sopa que es consumida a lo largo y ancho del Perú, y por supuesto, siempre con los pescados propios de la región lo que le dan un toque especial y característico.", R.drawable.ic_chilcano),
    MyMessage("Jalea de Pescado", "Plato popular fresco a base de pescado y mariscos que nuestra infinita costa nos puede brindar.", R.drawable.ic_jalea)
)

private val listaSierra: List<MyMessage> = listOf(
    MyMessage("Locro de Pecho","La receta de Locro de Pecho es típica de nuestras tierras peruanas, y representativa específicamente de la región de Arequipa.", R.drawable.ic_locro_pecho),
    MyMessage("Caldo verde","La receta del Caldo Verde Cajamarquino es muy consumida en los días de invierno y también en días de malestar, puesto que se habla con frecuencia de sus propiedades paliativas y curativas.", R.drawable.ic_caldo_verde),
    MyMessage("Papas con mani","Un plato que goza de unas papas bien cocidas y una exquisita salsa de maní recubriendo a las mismas", R.drawable.ic_papas_mani),
    MyMessage("Picante de Cuy","El Picante de Cuy, también llamado Cuy Colorado, es una receta pre-inca, originaria de la Sierra peruana. ", R.drawable.ic_picante_cuy),
    MyMessage("Patasca","Se trata de un rico caldo con mote de las zonas alto-andinas del Perú, siendo este de los más populares, aún más en la sierra", R.drawable.ic_patasca),
    MyMessage("Escribano Arequipeño","El Escribano arequipeño es una entrada o piqueo típico del departamento de Arequipa, una combinación muy fresca y sabrosa a base de papas, tomate y rocoto", R.drawable.ic_escribano),
    MyMessage("Pachamanca a la Olla","Plato originario del antiguo Perú,este plato se prepara bajo tierra, en un horno hecho con piedras y que es cubierto por hojas de choclo , varias carnes,verduras y tubérculos y humitas de maíz.", R.drawable.ic_pachamanca),
    MyMessage("Chupe de Habas","Es una exquisita sopa que incluye la mezcla de los sabores del ají peruano, la pasta de tomate, la cebolla y el ajo junto con las habas y el rico caldo de carne o pollo", R.drawable.ic_chupe_de_habas),
    MyMessage("Guiso de Quinua","Consiste plenamente en lavar la quinua continuamente y luego dejarla hervir con un caldo de verduras y algo de leche evaporada.", R.drawable.ic_guiso_quinua)
)

private val listaSelva: List<MyMessage> = listOf(
    MyMessage("Juane","Plato oriundo de Moyobamba que se asemeja a un tamal muy grande a base de arroz, pollo o gallina y huevo.", R.drawable.ic_juane),
    MyMessage("Tacacho con cecina y chorizo","Plato emblemático de la selva peruana. Consta de plátano verde (frito o asado) el cual es machacado y mezclado con manteca de cerdo.Se acompaña con cecina y chorizo.", R.drawable.ic_tacacho),
    MyMessage("Patarashca","Pescado de río condimentado con especias propias de la selva peruana, envuelto en una hoja y asado en carbón", R.drawable.ic_patashca),
    MyMessage("Inchicapi de gallina con maní","Exquisita sopa de la Amazonía, la cual tiene como peculiar ingrediente a la gallina criada en corral (gallina doméstica), maní licuado o molido, maíz, yuca y cilantro.", R.drawable.ic_inchicapi),
    MyMessage("Cazuela de pescado","Este plato consiste en un guiso o potaje a base de pescados y moluscos variados, todos ellos se mezclan con arroz hervido y verduras (pimiento, zanahoria, tomate, etc.).", R.drawable.ic_cazuela),
    MyMessage("Purtumute","Consiste en un guiso cuyo ingrediente base son los frijoles, tanto blancos como negros, los cuales se condimentan con mote y cilantro.", R.drawable.ic_purtumute),
    MyMessage("Humitas","Se trata de hojas de mazorca de maíz, llamadas a nivel local chala o panca, rellenas de una pasta hecha con maíz y aliñada con especias de la selva peruana.", R.drawable.ic_humitas),
    MyMessage("Trucha frita","Exquisito pescado de río acompañado de rodajas de limón y hojas frescas de perejil esparcidas como decoración.", R.drawable.ic_trucha),
    MyMessage("Ensalada de chonta o palmito","La ensalada de chonta o palmito es una comida típica en Semana Santa, se puede preparar con aguacate, jitomate y otros ingredientes de tu preferencia.", R.drawable.ic_chonta)
)

@Composable
fun SegundaVentana(navController: NavController, text: String?){
    Scaffold(topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow back",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Platos de la "+text)
        }
    }) {
        if(text == "Costa") {
            Lista(navController, text, listaCosta)
        } else if(text == "Sierra") {
            Lista(navController, text, listaSierra)
        } else {
            Lista(navController, text, listaSelva)
        }
    }
}

@Composable
fun Lista(navController: NavController, text: String?, messages: List<MyMessage>) {
    LazyColumn {
        items(messages) { message->
            Contenido(navController = navController, text = text, message = message)
        }
    }
}
@Composable
fun Contenido(navController: NavController, text: String?, message: MyMessage) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(message.ic_comida),
            contentDescription = "Lomo Saltado - Imagen Referencial",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = message.title,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(
                    text = message.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

data class MyMessage(val title: String, val body: String, val ic_comida: kotlin.Int)
