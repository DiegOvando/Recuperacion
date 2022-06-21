package com.example.recuperacion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnLimpiar, btnEnviar, btnSalir;
    private EditText txtCodigo, txtDescripcion, txtUnidad, txtVenta, txtCompra, txtCantidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        txtCodigo = (EditText) findViewById(R.id.txtCodigo);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        txtUnidad = (EditText) findViewById(R.id.txtUnidad);
        txtVenta = (EditText) findViewById(R.id.txtVenta);
        txtCompra = (EditText) findViewById(R.id.txtCompra);
        txtCantidad = (EditText) findViewById(R.id.txtCantidad);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCodigo.setText("");
                txtDescripcion.setText("");
                txtUnidad.setText("");
                txtVenta.setText("");
                txtCompra.setText("");
                txtCantidad.setText("");
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtCodigo.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor ingresar el codigo",
                            Toast.LENGTH_SHORT).show();
                }
                if(txtDescripcion.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor de ingresar la descripcion",
                            Toast.LENGTH_SHORT).show();
                }
                if(txtUnidad.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor de ingresar las unidades",
                            Toast.LENGTH_SHORT).show();
                }
                if(txtVenta.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor de ingresar el precio de venta",
                            Toast.LENGTH_SHORT).show();
                }
                if(txtCompra.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor de ingresar el precio de compra",
                            Toast.LENGTH_SHORT).show();
                }
                if(txtCantidad.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor de ingresar la cantidad",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    //Funciones
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("codigo", txtCodigo.getText().toString());
                    bundle.putSerializable("descripcion", txtDescripcion.getText().toString());
                    bundle.putSerializable("unidad", txtUnidad.getText().toString());
                    bundle.putSerializable("venta", txtVenta.getText().toString());
                    bundle.putSerializable("compra", txtCompra.getText().toString());
                    bundle.putSerializable("cantidad", txtCantidad.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(MainActivity.this);
                confirmar.setTitle("¿Cerrar App?");
                confirmar.setMessage("Se descartara toda la informacion. ");
                confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Nada
                    }
                }); confirmar.show();
            }
        });
    }
}
