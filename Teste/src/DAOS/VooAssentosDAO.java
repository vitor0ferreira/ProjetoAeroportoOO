/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import DAOS.PassageiroDAO;
import model.Voo;
import model.VooAssentos;
import model.Passageiro;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

/**
 *
 * @author vinic
 */
public class VooAssentosDAO {
    VooAssentos[] vooAssentos = new VooAssentos[100];
    
    private VooDAO voos;
    private PassageiroDAO passageiros;

    public VooAssentosDAO(VooDAO voos, PassageiroDAO passageiros) {
    
    }

    public int contarAssentosPorVoo(String idVoo){
        int assentosDisponiveis = 0;
        for(int i=0; i < vooAssentos.length; i++){
            if(vooAssentos[i] != null && vooAssentos[i].getIdVoo().toLowerCase().equals(idVoo.toLowerCase()))
                assentosDisponiveis++;
        }
        return assentosDisponiveis;
    }
    
    public VooAssentos buscarAssentoPorVooEPassageiro(String idVoo, int idPassageiro) {
        for (int i = 0; i < vooAssentos.length; i++) {
            if (vooAssentos[i] != null &&
                vooAssentos[i].getIdVoo().toLowerCase().equals(idVoo.toLowerCase()) &&
                vooAssentos[i].getIdPassageiro() == idPassageiro) {
                return vooAssentos[i];
            }
        }
        return null;
    }
    
    public String buscarvooAssentosPorID(String idAssento){
        boolean vazio = true;
        String selecaoAssentos = "";
        for(int i=0; i<vooAssentos.length; i++){
            if(vooAssentos[i]!=null && vooAssentos[i].getIdAssento().toUpperCase().equals((idAssento).toUpperCase())){
                selecaoAssentos += vooAssentos[i].toString();
                vazio = false;
            }
        }
        if(vazio){
            selecaoAssentos = "Nao existe assento com este ID cadastrado";
        }
        return selecaoAssentos;
    }
    
    public String mostrarTodosAssentosPorVoo(Voo voo){
        boolean vazio = true;
        String todosPassageiros = "";
        for(int i=0; i<vooAssentos.length; i++){
            if(vooAssentos[i] != null && vooAssentos[i].getIdVoo().toLowerCase().equals(voo.getId().toLowerCase())){
                todosPassageiros += vooAssentos[i].toString();
                vazio = false;
            }
        }
        if(vazio){
            todosPassageiros += "Nao existe nenhum assento neste voo cadastrado";
        } 
        return todosPassageiros;
    }
    
    public String mostrarTodos(){
        boolean vazio = true;
        String todosPassageiros = "";
        for(int i=0; i<vooAssentos.length; i++){
            if(vooAssentos[i] != null){
                todosPassageiros += vooAssentos[i].toString();
                vazio = false;
            }
        }
        if(vazio){
            todosPassageiros += "Nao existe nenhum assento neste voo cadastrado";
        } 
        return todosPassageiros;
    }
    
    public boolean adicionaVooAssentos(VooAssentos vooAssento){
        int posicao = this.posicaoLivre();
        if(posicao != -1){
            vooAssentos[posicao] = vooAssento;
            return true;
        } else{
            return false;
        }
    }
        
    private int posicaoLivre(){
        for(int i=0; i<vooAssentos.length; i++){
            if(vooAssentos[i] == null){
                return i;
            }
        }
        return -1;
    }
}
