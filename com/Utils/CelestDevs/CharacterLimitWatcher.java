package com.Utils.CelestDevs;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class CharacterLimitWatcher implements TextWatcher {

    private int limit;

    public CharacterLimitWatcher(int limit) {
        this.limit = limit;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // Não é necessário implementar nesta fase
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // Não é necessário implementar nesta fase
    }

    @Override
    public void afterTextChanged(Editable editable) {
        String text = editable.toString();

        if (text.length() > limit) {
            // Adicione a lógica desejada aqui, como exibir uma mensagem ou desativar a entrada.
            // Neste exemplo, estamos apenas limitando o número de caracteres sem ação adicional.
            editable.replace(limit, text.length(), "");
        }
    }
}
