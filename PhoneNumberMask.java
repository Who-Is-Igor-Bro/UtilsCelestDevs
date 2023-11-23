import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class PhoneNumberMask implements TextWatcher {
    private EditText editText;
    private String formatPattern;

    public PhoneNumberMask(EditText editText, String formatPattern) {
        this.editText = editText;
        this.formatPattern = formatPattern;
        editText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
        // Não é necessário implementar nesta fase
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        // Não é necessário implementar nesta fase
    }

    @Override
    public void afterTextChanged(Editable editable) {
        String input = editable.toString();

        // Remove qualquer formatação anterior para evitar conflitos
        String phoneNumber = input.replaceAll("[^\\d]", "");

        // Aplica o padrão de formatação
        phoneNumber = applyFormatPattern(phoneNumber);

        // Evita a recursividade infinita ao definir o texto
        editText.removeTextChangedListener(this);
        editText.setText(phoneNumber);
        editText.setSelection(phoneNumber.length());
        editText.addTextChangedListener(this);
    }

    private String applyFormatPattern(String phoneNumber) {
        StringBuilder formattedNumber = new StringBuilder();
        int patternIndex = 0;
        int numberIndex = 0;

        while (patternIndex < formatPattern.length() && numberIndex < phoneNumber.length()) {
            char patternChar = formatPattern.charAt(patternIndex);
            char numberChar = phoneNumber.charAt(numberIndex);

            if (patternChar == '#') {
                formattedNumber.append(numberChar);
                numberIndex++;
            } else {
                formattedNumber.append(patternChar);
            }

            patternIndex++;
        }

        return formattedNumber.toString();
    }
  }
