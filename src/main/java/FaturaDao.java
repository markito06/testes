import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FaturaDao {

    public List<Fatura> buscarFaturasVencidas(){
        List<Fatura> faturasVencidas = new ArrayList<>();
        Fatura f1 = new Fatura ("joao@joao.com", 350.0, LocalDate.now().minusDays(3));
        Fatura f2 = new Fatura ("maria@maria.com", 150.0, LocalDate.now().minusDays(2));
        Fatura f3 = new Fatura ("jose@jose.com", 150.0, LocalDate.now().minusDays(5));
        faturasVencidas.add(f1);
        faturasVencidas.add(f2);
        faturasVencidas.add(f3);

        return faturasVencidas;
    }
}
