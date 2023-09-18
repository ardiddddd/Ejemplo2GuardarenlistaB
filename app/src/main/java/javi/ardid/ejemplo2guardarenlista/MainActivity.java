package javi.ardid.ejemplo2guardarenlista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import javi.ardid.ejemplo2guardarenlista.modelos.Usuario;

public class MainActivity extends AppCompatActivity {
    //Variables de la vista o la interfaz
    private Button btnRegistrar;
    private EditText txtEmail;
    private EditText txtPassword;



    //Variables para la lógica
    ArrayList<Usuario> listaUsuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // INICIALIZO TODO
        listaUsuarios = new ArrayList<>();

        inicializaVista();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Coger los textos de las cajas
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();

                //Comprobar que estan rellenados y sino advertirlo
                if(email.isEmpty() || password.isEmpty()){
                    //No se puede guardar
                    Toast.makeText(MainActivity.this, "FALTAN DATOS!", Toast.LENGTH_SHORT).show();
                }else{
                    //Se puede guardar
                    Usuario miusuario = new Usuario(email, password);
                    listaUsuarios.add(miusuario);
                    Toast.makeText(MainActivity.this, "Usuario almacenado"+miusuario.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void inicializaVista() {
        txtEmail = findViewById(R.id.txtEmailMain);
        txtPassword = findViewById(R.id.txtPasswordMain);
        btnRegistrar = findViewById(R.id.btnRegisterMain);
    }
}