package br.com.ifpe.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tb_professor")
@DiscriminatorValue(value="P") //Valor usado no campo descriminador
@PrimaryKeyJoinColumn( //Definindo a PK de Professor
        name="id_professor", //Nome da coluna PK de Professor
        referencedColumnName="id_usuario" //Referencia a PK de Usuario
)
public class Professor extends Usuario implements Serializable {
    
    @Column(name="siape", nullable = false, length = 8)
    private int siape;
    
    @Column(name="departamento", nullable = false, length = 100)
    private String departamento;
    
    @Column(name="ramal", nullable = false, length = 15)
    private Long ramal;

    
    public int getSiape() {
        return this.siape;
    }

    public void setSiape(int siape) {
        this.siape = siape;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Long getRamal() {
        return this.ramal;
    }

    public void setRamal(Long ramal) {
        this.ramal = ramal;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        hash += (super.getIdUsuario() != null ? super.getIdUsuario().hashCode():0);
        return hash;
    }
    
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Professor)) {
            return false; //Se não for a instância desejada, retorna false;
        }else{ 
            Professor other = (Professor) o;
            return !((super.getIdUsuario() == null && other.getIdUsuario() != null)
                    ||(super.getIdUsuario() != null && 
                    !super.getIdUsuario().equals(other.getIdUsuario()))
            );
        /* 
         * Se a sentença for verdadeira, retorna false. 
         * Se for falsa, retorna true.        
         */
        }
    }
    
}
