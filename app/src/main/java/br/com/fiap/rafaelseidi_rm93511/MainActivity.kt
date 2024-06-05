package br.com.fiap.rafaelseidi_rm93511

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.rafaelseidi_rm93511.ui.theme.RafaelSeidi_RM93511Theme
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.button)
        val praia = findViewById<EditText>(R.id.praia)
        val estado = findViewById<EditText>(R.id.estado)
        val cidade = findViewById<EditText>(R.id.cidade)

        button.setOnClickListener {
            if (praia.text.isEmpty()) {
                praia.error = "Preencha o campo"
                return@setOnClickListener
            } else if (estado.text.isEmpty()) {
                estado.error = "Preencha o campo"
                return@setOnClickListener
            } else if (cidade.text.isEmpty()) {
                cidade.error = "Preencha o campo"
                return@setOnClickListener
            }

            val item = ItemModel(
                name = praia.text.toString(),
                estado = estado.text.toString(),
                cidade = cidade.text.toString(),
                onRemove = {
                    itemsAdapter.removeItem(it)
                }
            )

            itemsAdapter.addItem(item)
            praia.text.clear()
            estado.text.clear()
            cidade.text.clear()
        }

    }
}