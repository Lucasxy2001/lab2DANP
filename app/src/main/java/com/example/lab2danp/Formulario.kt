package com.example.lab2danp

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun Formulario(
    dni: String,
    funDni: (String) -> Unit,
    nombreCompleto: String,
    funNombreCompleto: (String) -> Unit,
    fechaDeInscripcion: String,
    funFechaDeInscripcion: (String) -> Unit,
    tipoDeSangre: String,
    funTipoDeSangre: (String) -> Unit,

    telefono: String,
    funTelefono: (String) -> Unit,
    montoPagado: String,
    funMontoPagado: (String) -> Unit,

    isEditando: Boolean,
    funIsEditando: () -> Unit,
    textButton: String,
    funTextButton: (String) -> Unit,

    listaAsistentes: MutableList<Asistente>,
    funResetCampos: () -> Unit
) {
    Text(text = "Datos del Asistente", fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.padding(vertical = 6.dp))

    //DNI
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = dni,

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,

        onValueChange = { funDni(it) },
        label = { Text(text = "DNI") },
        enabled = !isEditando
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    //Nombres Completos
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = nombreCompleto,

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,

        onValueChange = { funNombreCompleto(it) },
        label = { Text(text = "Nombre Completo") },
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    //Fecha De Inscripcion
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = fechaDeInscripcion,

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,

        onValueChange = { funFechaDeInscripcion(it) },
        label = { Text(text = "Fecha De Inscripción (dd-mm-aaaa)")},
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    //Tipo De Sangre
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = tipoDeSangre,

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,

        onValueChange = { funTipoDeSangre(it) },
        label = { Text(text = "Tipo De Sangre") },
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    //Telefono
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = telefono,

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        maxLines = 1,

        onValueChange = { funTelefono(it) },
        label = { Text(text = "Telefono") },
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    //Monto Pagado
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = montoPagado,

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        maxLines = 1,

        onValueChange = { funMontoPagado(it) },
        label = { Text(text = "Monto Pagado (S/.)") },
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    //Botón Agregar Asistente
    Button(
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
        onClick = {
            if (isEditando) {
                editarAsistente(dni,nombreCompleto,fechaDeInscripcion,tipoDeSangre,telefono,montoPagado,listaAsistentes)
                funTextButton("Agregar Asistente")
                funIsEditando()
            } else {
                agregarAsistente(dni,nombreCompleto,fechaDeInscripcion,tipoDeSangre,telefono,montoPagado,listaAsistentes)
            }
            funResetCampos()
        }
    ) {
        Text(
            color = Color.White,
            text = textButton
        )
    }
}