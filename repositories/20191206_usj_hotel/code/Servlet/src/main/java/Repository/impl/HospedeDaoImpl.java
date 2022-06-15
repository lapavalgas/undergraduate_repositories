package Repository.impl;

import Model.Hospede;

public interface HospedeDaoImpl {

    public void createHospede (Hospede _hospede);
    
    public Hospede readHospede (String _cpf);

    public void updateHospede (Hospede _hospede);

    public void deleteHospede (String _cpf);

}