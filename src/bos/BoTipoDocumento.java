/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bos;

import daos.DaoTipoDocumento;
import java.util.List;
import modelo.Tipo_Documento;

/**
 *
 * @author F González Barrera
 */
public class BoTipoDocumento {

    public BoTipoDocumento() {
    }
    
    public List<Tipo_Documento> listar(){
        return new DaoTipoDocumento().listar();
    }
}
