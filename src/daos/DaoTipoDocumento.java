/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IdaoTipoDocumento;
import java.util.ArrayList;
import java.util.List;
import modelo.Tipo_Documento;
import utilidades.Codificador;
import utilidades.Lector;

/**
 *
 * @author F González Barrera
 */
public class DaoTipoDocumento implements IdaoTipoDocumento{
     /*
     Utilidad que codifica y decodifica los datos que se van a persistir para 
     que no sea de tan facil acceso a externos o usuarios no deseados
     */
    private final Codificador codificador = new Codificador();

    /*
     Preparación de archivo plano
     */
    private final String ruta = "D:/SEBRALO/";

    public DaoTipoDocumento() {
    }
    
    @Override
    public List<Tipo_Documento> listar(){
        List<Tipo_Documento> retorno = new ArrayList<>();
        //leemos del archivo plano
        List<String> lee = new Lector().leer(ruta, Tipo_Documento.ARCHIVO);
        for (String registro : lee) {//sacamos los registros
            //los decodificamos
            String[] split = codificador.decodificarPalabra(registro).split(" - ");
            //agregamos el registro, transformandolo en tipo_usuario para ser retornado
            retorno.add(new Tipo_Documento(Integer.parseInt(split[0]), split[1]));
        }
        //retornamos el resultado que puede ser ninguno o varios
        return retorno;
    }
}
