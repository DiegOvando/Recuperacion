package com.example.recuperacion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button btnCalcular, btnRegresar;
    private TextView lblProducto, lblTotalVenta, lblTotalCompra, lblTotalGanancia, lblCompra ,lblVenta, lblUnidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle datos = getIntent().getExtras();

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);

        lblProducto = (TextView) findViewById(R.id.lblProducto);
        lblTotalVenta = (TextView) findViewById(R.id.lblTotalVenta);
        lblTotalCompra = (TextView) findViewById(R.id.lblTotalCompra);
        lblTotalGanancia = (TextView) findViewById(R.id.lblTotalGanancia);
        lblCompra = (TextView) findViewById(R.id.lblCompra);
        lblVenta = (TextView) findViewById(R.id.lblVenta);
        lblUnidad = (TextView) findViewById(R.id.lblUnidad);

        lblProducto.setText(datos.getString("descripcion"));
        lblCompra.setText(datos.getString("compra"));
        lblVenta.setText(datos.getString("venta"));
        lblUnidad.setText(datos.getString("cantidad"));
//        lblTotalVenta.setText(datos.getString(""));
//        lblTotalCompra.setText(datos.getString(""));
//        lblTotalGanancia.setText(datos.getString(""));

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final float compra = Float.parseFloat(lblCompra.getText().toString());
                final float venta = Float.parseFloat(lblVenta.getText().toString());
                final float unidad = Float.parseFloat(lblUnidad.getText().toString());
                Abarrote abarrote = new Abarrote(compra, venta, unidad);
                lblTotalCompra.setText(""+abarrote.calcularVenta());
                lblTotalVenta.setText(""+abarrote.calcularCompra());
                lblTotalGanancia.setText(""+abarrote.calcularGanancia());
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(SecondActivity.this);
                confirmar.setTitle("¿Regresar?");
                confirmar.setMessage("Se descartará toda la información ingresada");
                confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //nada
                    }
                });
                confirmar.show();
            }
        });
    }
}
