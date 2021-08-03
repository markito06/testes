import java.util.List;

public class Exemplo {

    public static void main(String[] args) {
        EnviadorEmail enviadorEmail = new EnviadorEmail();
        List<Fatura> faturasVencidas = new FaturaDao().buscarFaturasVencidas();
        //exmplo tradicional
        for(Fatura fatura : faturasVencidas){
            enviadorEmail.enviar(fatura.getEmailDevedor(), fatura.resumo());
        }

        //lambda
        faturasVencidas.forEach(fatura ->  enviadorEmail.enviar(fatura.getEmailDevedor(), fatura.resumo()));

    }
}
