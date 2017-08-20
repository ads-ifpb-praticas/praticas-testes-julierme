import br.edu.ifpb.praticas.testes.praticas.testess.Emprestimo;
import br.edu.ifpb.praticas.testes.praticas.testess.Filme;
import br.edu.ifpb.praticas.testes.praticas.testess.regras.RegrasEmprestimo;
import java.sql.SQLException;
import java.util.Calendar;
import org.junit.Assert;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julierme Heinstein
 */
public class TesteEmprestimo {
        private final RegrasEmprestimo validador = new RegrasEmprestimo();

        @Test
        public void testaEmprestimoNulo() {
            Assert.assertFalse(validador.emprestaFilme(null));
            Assert.assertFalse(validador.devolveFilme(null));
        }

        @Test
        public void testaDataRetroativa() throws SQLException {
            Filme filme = new Filme(01, "Criança morta", "terror", 123);
            Emprestimo emprestimo = new Emprestimo();
            Assert.assertFalse(validador.emprestaFilme(filme.getID()));
        }

        @Test
        public void testaSituacao() {
            Filme filme = new Filme(01, "Criança morta", "terror", 123);
            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setIDFilme(filme.getID());
            Assert.assertEquals(emprestimo.getEmprestimo(), filme.getEstado());
        }

        @Test
        public void testaFilmeNulo() throws SQLException {
            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setID(null);
            Assert.assertFalse(validador.emprestaFilme(emprestimo.getID()));
        }

        @Test
        public void testaDevolucaoRetroativa() throws SQLException {
            Filme filme = new Filme(02, "As crônicas de nárnia", "aventura", 123);
            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setIDFilme(filme.getID());
            emprestimo.setDevolucao(Calendar.DATE);
            Assert.assertFalse(validador.devolveFilme(emprestimo.getIDFilme()));
        }
}
