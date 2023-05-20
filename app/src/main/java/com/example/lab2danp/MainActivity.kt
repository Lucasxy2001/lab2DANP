package com.example.lab2danp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab2danp.ui.theme.Lab2DANPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2DANPTheme {

                val listaAsistentes = remember { mutableStateListOf<Asistente>() }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                )
                {
                    Box(modifier = Modifier.fillMaxSize()) {
                        ScreenCRUD(listaAsistentes)
                    }
                }
            }
        }
    }
}

@Composable
fun ScreenCRUD(listaAsistentes: MutableList<Asistente>) {
    //Estados relacionados a las propiedades de la clase Asistente
    var dni by remember { mutableStateOf("") }
    var nombresCompletos by remember { mutableStateOf("") }
    var fechaDeInscripcion by remember { mutableStateOf("") }
    var tipoDeSangre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var montoPagado by remember { mutableStateOf("") }

    //Estados para el CRUD
    var isEditando by remember { mutableStateOf(false) }
    var textButton by remember { mutableStateOf("Agregar Asistente") }

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(12.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Formulario(
                dni = dni,
                funDni = { dni = it },
                nombreCompleto = nombresCompletos,
                funNombreCompleto = { nombresCompletos = it },
                fechaDeInscripcion = fechaDeInscripcion,
                funFechaDeInscripcion = { fechaDeInscripcion = it },
                tipoDeSangre = tipoDeSangre,
                funTipoDeSangre = { tipoDeSangre = it },
                telefono = telefono,
                funTelefono = { telefono = it },
                montoPagado = montoPagado,
                funMontoPagado = { montoPagado = it },

                isEditando = isEditando,
                funIsEditando = { isEditando = false },
                textButton = textButton,
                funTextButton = { textButton = it },

                listaAsistentes = listaAsistentes,
                funResetCampos = {
                    dni = ""
                    nombresCompletos = ""
                    fechaDeInscripcion = ""
                    tipoDeSangre = ""
                    telefono = ""
                    montoPagado = ""
                }
            )

            Column(modifier = Modifier.fillMaxWidth()) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items(listaAsistentes) { asistente ->
                        CardAsistente(
                            funDni = { dni = it },
                            funNombreCompleto = { nombresCompletos = it },
                            funFechaDeInscripcion = { fechaDeInscripcion = it },
                            funTipoDeSangre = { tipoDeSangre = it },
                            funTelefono = { telefono = it },
                            funMontoPagado = { montoPagado = it },

                            funTextButton = { textButton = it },
                            funIsEditando = { isEditando = it },

                            funBorrarAsistente = { borrarAsistente(it, listaAsistentes) },
                            asistente = asistente
                        )
                    }
                }
            }
        }
    }
}

//Funciones CRUD
fun agregarAsistente(dni: String, nombreCompleto: String, fechaDeInscripcion: String, tipoDeSangre: String,
                     telefono: String, montoPagado: String, listaAsistentes: MutableList<Asistente>) {
    listaAsistentes.add(Asistente(dni, nombreCompleto, fechaDeInscripcion, tipoDeSangre, telefono, montoPagado))
}

fun editarAsistente(dni: String, nombreCompleto: String, fechaDeInscripcion: String, tipoDeSangre: String,
                    telefono: String, montoPagado: String, listaAsistentes: MutableList<Asistente>) {
    listaAsistentes.forEach { asistente ->
        if (asistente.dni == dni) {
            asistente.nombreCompleto = nombreCompleto
            asistente.fechaDeInscripcion = fechaDeInscripcion
            asistente.tipoDeSangre = tipoDeSangre
            asistente.telefono = telefono
            asistente.montoPagado = montoPagado
        }
    }
}

fun borrarAsistente(dni: String, listaAsistentes: MutableList<Asistente>) {
    listaAsistentes.forEach { asistente ->
        if (asistente.dni == dni) {
            listaAsistentes.remove(asistente)
        }
    }
}
