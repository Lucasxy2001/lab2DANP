package com.example.lab2danp

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CardAsistente(
    funDni: (String) -> Unit,
    funNombreCompleto: (String) -> Unit,
    funFechaDeInscripcion: (String) -> Unit,
    funTipoDeSangre: (String) -> Unit,
    funTelefono: (String) -> Unit,
    funMontoPagado: (String) -> Unit,

    funTextButton: (String) -> Unit,
    funIsEditando: (Boolean) -> Unit,

    funBorrarAsistente: (String) -> Unit,
    asistente: Asistente
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = 8.dp
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp), Arrangement.Center) {
            Text(text = asistente.dni, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = asistente.nombreCompleto, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = asistente.fechaDeInscripcion, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = asistente.tipoDeSangre, modifier = Modifier.align(Alignment.CenterHorizontally))

            Text(text = asistente.telefono.toString(), modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = asistente.montoPagado.toString(), modifier = Modifier.align(Alignment.CenterHorizontally))
            
            Row(modifier = Modifier.fillMaxWidth()) {
                //Botón Editar
                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                    onClick = {
                        funDni(asistente.dni)
                        funNombreCompleto(asistente.nombreCompleto)
                        funFechaDeInscripcion(asistente.fechaDeInscripcion)
                        funTipoDeSangre(asistente.tipoDeSangre)
                        funTelefono(asistente.telefono)
                        funMontoPagado(asistente.montoPagado)

                        funTextButton("Guardar Cambios")
                        funIsEditando(true)
                    }
                ) {
                    Text(text = "Editar", color = Color.White)
                }

                //Botón Borrar
                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                    onClick = {
                        funBorrarAsistente(asistente.dni)
                    }
                ) {
                    Text(text = "Borrar", color = Color.White)
                }
            }
        }
    }
}