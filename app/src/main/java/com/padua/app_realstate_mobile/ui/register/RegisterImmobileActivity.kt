package com.padua.app_realstate_mobile.ui.register

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.padua.app_realstate_mobile.R
import com.padua.app_realstate_mobile.model.Immobile
import com.padua.app_realstate_mobile.utils.Utils
import kotlinx.android.synthetic.main.activity_register_immobile.*
import kotlinx.android.synthetic.main.dialog_immobile.view.*

@RequiresApi(Build.VERSION_CODES.M)
class RegisterImmobileActivity : AppCompatActivity() {

    private lateinit var immobile: Immobile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_immobile)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        immobile = Immobile()

        animateButtons()
        buttonRegisterImmobile.setOnClickListener(buttonClickRegister)
    }

    private val buttonClickRegister =
        View.OnClickListener {
            verifyValueImmobile()
        }

    private fun verifyValueImmobile() {
        if(validateForm()) {
            immobile.tamanho = editTextTamanho.text.toString().toInt()
            immobile.quarto = editTextNumQuartos.text.toString().toInt()
            immobile.banheiro = editTextNumBanheiro.text.toString().toInt()
            immobile.suite = editTextSuite.text.toString()
            immobile.piso = editTextPiso.text.toString()
            immobile.varanda = editTextVaranda.text.toString()
            immobile.garagem = editTextGaragem.text.toString()
            immobile.piscina = editTextPiscina.text.toString()
            immobile.moveisImbutidos = editTextMoveisImbutidos.text.toString()
            immobile.bairro = editTextBairro.text.toString()
            immobile.cidade = editTextCidade.text.toString()
            immobile.estado = editTextEstado.text.toString()
            immobile.preco = editTextPreco.text.toString().toInt()

            openDialog(immobile)
        }
    }

    private fun validateForm(): Boolean {
        when {
            editTextTamanho.text.toString().isEmpty() -> {
                tilTamanho.error = "Campo obrigatório!"
                return false
            }
            editTextNumQuartos.text.toString().isEmpty() -> {
                tilNumQuartos.error = "Campo obrigatório!"
                return false
            }
            editTextNumBanheiro.text.toString().isEmpty() -> {
                tilNumBanheiro.error = "Campo obrigatório!"
                return false
            }
            editTextSuite.text.toString().isEmpty() -> {
                tilSuite.error = "Campo obrigatório!"
                return false
            }
            editTextPiso.text.toString().isEmpty() -> {
                tilPiso.error = "Campo obrigatório!"
                return false
            }
            editTextVaranda.text.toString().isEmpty() -> {
                tilVaranda.error = "Campo obrigatório!"
                return false
            }
            editTextGaragem.text.toString().isEmpty() -> {
                tilGaragem.error = "Campo obrigatório!"
                return false
            }
            editTextPiscina.text.toString().isEmpty() -> {
                tilPiscina.error = "Campo obrigatório!"
                return false
            }
            editTextMoveisImbutidos.text.toString().isEmpty() -> {
                tilMoveisImbutidos.error = "Campo obrigatório!"
                return false
            }
            editTextBairro.text.toString().isEmpty() -> {
                tilBairro.error = "Campo obrigatório!"
                return false
            }
            editTextCidade.text.toString().isEmpty() -> {
                tilCidade.error = "Campo obrigatório!"
                return false
            }
            editTextEstado.text.toString().isEmpty() -> {
                tilEstado.error = "Campo obrigatório!"
                return false
            }
            editTextPreco.text.toString().isEmpty() -> {
                tilPreco.error = "Campo obrigatório!"
                return false
            }
            else -> return true
        }
    }

    private fun showMessage(message: String){
        Snackbar.make(
            findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_LONG
        ).show()
    }

    @SuppressLint("SetTextI18n")
    fun openDialog(immobile: Immobile){
        val dialog = LayoutInflater.from(this).inflate(R.layout.dialog_immobile, null)
        val builder = AlertDialog.Builder(this).setView(dialog)
        val alert = builder.show()

        dialog.textTipo.text = "Casa"
        dialog.textQuarto.text = immobile.quarto.toString() + " Quartos"
        dialog.textBanheiro.text = immobile.banheiro.toString() + " Banheiros"
        if(immobile.varanda == "Sim" || immobile.varanda == "sim")
            dialog.textLavanda.text = "Possui Varanda"
        else
            dialog.textLavanda.text = "Não possui Varanda"
        dialog.textPiso.text = immobile.piso
        if(immobile.garagem == "Sim" || immobile.garagem == "sim")
            dialog.textGaragem.text = "Possui Garagem"
        else
            dialog.textGaragem.text = "Não possui Garagem"
        dialog.textAluguel.text = "Aluguel: R$ 500,00"
        dialog.textVenda.text = "Venda: R$ " + immobile.preco.toString() + ",00"

        dialog.button_disponibilizar_imovel.setOnClickListener {
            dialog.progress_bar_register.visibility = View.VISIBLE
            dialog.text_register.visibility = View.GONE

            Handler().postDelayed(
                {
                    alert.dismiss()
                    showMessage("Sua solicitação de para venda do imóvel foi enviada com sucesso! Aguarde nosso retorno.")
                },
                2000 // value in milliseconds
            )
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    private fun animateButtons(){
        Utils.setPushDownAnimation(buttonRegisterImmobile)
    }
}
