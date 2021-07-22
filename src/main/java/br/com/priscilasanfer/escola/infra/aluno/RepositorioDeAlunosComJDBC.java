package br.com.priscilasanfer.escola.infra.aluno;

import br.com.priscilasanfer.escola.dominio.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAluno {
    private final Connection connection;

    public RepositorioDeAlunosComJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        try {
            String sql = "INSERT INTO ALUNO VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail());
            ps.execute();

            sql = "INSERT INTO TELEFONE VALUES(?,?)";
            ps = connection.prepareStatement(sql);

            for (Telefone telefone : aluno.getTelefones()) {
                ps.setString(1, telefone.getDdd());
                ps.setString(2, telefone.getNumero());
                ps.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscarPorCpf(Cpf cpf) {
        try {
            String sql = "select id, nome, email from aluno where cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumero());

            ResultSet rs = ps.executeQuery();

            boolean encontrou = rs.next();
            if (!encontrou) {
                throw new AlunoNaoEncontrado(cpf);
            }

            String nome = rs.getString("nome");
            Email email = new Email(rs.getString("nome"));
            Aluno encontrado = new Aluno(cpf, nome, email);

            Long id = rs.getLong("id");
            sql = "select ddd, numero from telefone where aluno_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ddd = rs.getString("ddd");
                String numero = rs.getString("numero");
                encontrado.adicionarTelefone(ddd, numero);
            }

            return encontrado;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {

        try {
            String sql = "select id, cpf, nome from aluno";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Aluno> alunos = new ArrayList<>();

            while (rs.next()) {
                Cpf cpf = new Cpf(rs.getString("cpf"));
                Email email = new Email(rs.getString("email"));
                String nome = rs.getString("nome");
                Aluno aluno = new Aluno(cpf, nome, email);

                Long id = rs.getLong("id");
                sql = "select ddd, numero from telefone where aluno_id = ?";
                PreparedStatement psTelefone = connection.prepareStatement(sql);
                psTelefone.setLong(1, id);
                ResultSet rsTelefone = psTelefone.executeQuery();
                while (rsTelefone.next()) {
                    String ddd = rs.getString("ddd");
                    String numero = rs.getString("numero");
                    aluno.adicionarTelefone(ddd, numero);
                }
                alunos.add(aluno);
            }

            return alunos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
