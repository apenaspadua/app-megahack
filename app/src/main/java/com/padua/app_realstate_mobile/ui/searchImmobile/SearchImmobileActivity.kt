package com.padua.app_realstate_mobile.ui.searchImmobile

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.widget.ListAdapter
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.padua.app_realstate_mobile.R
import com.padua.app_realstate_mobile.model.Immobile
import com.padua.app_realstate_mobile.network.bean.ImmobileResponse
import com.padua.app_realstate_mobile.ui.searchImmobile.adapter.SearchAdapter
import kotlinx.android.synthetic.main.activity_search_immobile.*
import kotlinx.android.synthetic.main.dialog_details_immobile.view.*
import kotlinx.android.synthetic.main.dialog_immobile.view.*
import kotlinx.android.synthetic.main.dialog_immobile.view.button_disponibilizar_imovel

@RequiresApi(Build.VERSION_CODES.M)
class SearchImmobileActivity : AppCompatActivity() {

    private lateinit var interactor: SeachImmobileContract.Interactor
    private lateinit var adapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_immobile)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        interactor = SearchImmobileInteractor(this)
        getListimmobile()
    }

    private fun getListimmobile() {
        progressBarList.visibility = View.VISIBLE
        interactor.getListImmobile()
    }

    fun createList(list: List<ImmobileResponse>){
        progressBarList.visibility = View.GONE
        val recyclerView = recycler
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = SearchAdapter(list, this, this)
        recyclerView.adapter = adapter
    }

    fun onError(message: String){
        Snackbar.make(
            findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_LONG
        ).show()
    }

    private fun showMessage(message: String){
        Snackbar.make(
            findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_LONG
        ).show()
    }

    @SuppressLint("SetTextI18n")
    fun openDialog(immobile: ImmobileResponse){
        val dialog = LayoutInflater.from(this).inflate(R.layout.dialog_details_immobile, null)
        val builder = AlertDialog.Builder(this).setView(dialog)
        val alert = builder.show()

        dialog.textDescricao.text = "Casa localizada no bairro " + immobile.bairro + " na cidade de " +
                immobile.cidade + "/" + immobile.estado
        dialog.textQuartoDetails.text = immobile.quarto.toString() + " Quartos"
        dialog.textBanheiroDetails.text = immobile.banheiro.toString() + " Banheiros"
        dialog.textLavandaDetails.text = "Varanda: " + immobile.varanda
        dialog.textPisoDetails.text = "Piso: " + immobile.piso
        dialog.textGaragemDetails.text = immobile.garagem.toString() + " Garagem"
        dialog.textVendaDetalhes.text = "Valor de venda: R$ " + immobile.preco.toString()

        dialog.button_marcar_visita.setOnClickListener {
            dialog.progress_bar_details.visibility = View.VISIBLE
            dialog.text_details_button.visibility = View.GONE

            Handler().postDelayed(
                {
                    alert.dismiss()
                    showMessage("Sua solicitação de visita foi enviada com sucesso! Aguarde nosso retorno.")
                },
                2000 // value in milliseconds
            )
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        finish()
    }
}
