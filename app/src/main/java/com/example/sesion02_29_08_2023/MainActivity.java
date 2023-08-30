package com.example.sesion02_29_08_2023;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre, txtApellido, txtCorreo, txtFecha;
    Spinner spnPasatiempo;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.idTxtNombre);
        txtApellido = findViewById(R.id.idTxtApellido);
        txtCorreo = findViewById(R.id.idtxtCorreo);
        spnPasatiempo = findViewById(R.id.idSpnPasatiempos);
        btnRegistrar = findViewById(R.id.idBtnRegistrar);
        txtFecha = findViewById(R.id.idTxtFecNac);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = txtNombre.getText().toString();
                String ape = txtApellido.getText().toString();
                String pas = spnPasatiempo.getSelectedItem().toString();
                String cor = txtCorreo.getText().toString();
                String fec = txtFecha.getText().toString();

                if (!nom.matches("[a-zA-z]{2,20}")){
                    txtNombre.setError("Nombre es de 2 a 20 Caracteres");
                    return;
                }
                if (!ape.matches("[a-zA-z]{2,20}")){
                    txtApellido.setError("Apellido es de 2 a 20 Caracteres");
                    return;
                }
                if (spnPasatiempo.getSelectedItemId() == 0){
                    mensajeToast("Seleccione un pasatiempo");
                    return;
                }
                if (!cor.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
                    txtCorreo.setError("El correo no tiene formato");
                    return;
                }
                String titulo = "DATOS DEL CLIENTE";
                String msg  = "Nombre : " + nom + "\n";
                       msg += "Apellido : " + ape + "\n";
                       msg += "Pasatiempo : " + pas + "\n";
                       msg += "Correo : " + cor + "\n";
                       msg += "Fecha : " + fec + "\n";

                mensajeAlert(titulo, msg);
            }
        });
    }

    public void mensajeAlert(String titulo, String msg){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage(msg);
        alertDialog.setTitle(titulo);
        alertDialog.setCancelable(true);
        alertDialog.show();
    }

    void mensajeToast(String mensaje){
        Toast toast1 =  Toast.makeText(getApplicationContext(),mensaje, Toast.LENGTH_LONG);
        toast1.show();
    }
}