import { EmpresasService } from './../../servicios/empresas.service';
import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AddEmpresaComponent } from './add-empresa/add-empresa.component';
import { Empresa } from 'src/app/modelos/Empresa.model';
import { ConfirmationDialogService } from 'src/app/servicios/confirmation-dialog.service';
import { UpdateEmpresaComponent } from './update-empresa/update-empresa.component';

@Component({
  selector: 'app-empresas',
  templateUrl: './empresas.component.html',
  styleUrls: ['./empresas.component.css']
})
export class EmpresasComponent implements OnInit {

  // Variables
  public dtOptions: DataTables.Settings = {};
  public empresas: Empresa[];

  constructor(
    private _empresas: EmpresasService,
    private modalService: NgbModal,
    private confirmationDialogService: ConfirmationDialogService
  ) { }

  ngOnInit(): void {
    this.opcionesDt();
    this.obtenerEmpresas();
  }

  // Opciones del DataTable
  opcionesDt(): void {
    this.dtOptions = {
      pageLength: 25, // Registros por pagina
      language: { url: '//cdn.datatables.net/plug-ins/1.10.11/i18n/Spanish.json' } // Español
    };
  }

  // Obtener lista de Empresas
  obtenerEmpresas(): void {
    this._empresas.getEmpresas().subscribe(data => {
      this.empresas = data;
    });
  }

  // Modal Nueva Empresa
  nuevaEmpresa() {
    const modalRef = this.modalService.open(AddEmpresaComponent);
    modalRef.result.then((result) => {
      this.ngOnInit();
    });
  }

  // Modal Editar Emrpesa
  editarEmpresa(empresa: Empresa) {
    const modalRef = this.modalService.open(UpdateEmpresaComponent);
    modalRef.componentInstance.empresa = empresa;
    modalRef.result.then((result) => {
      this.ngOnInit();
    });
  }

  // Borrar una Empresa
  borrarEmpresa(empresa: Empresa) {
    this.confirmationDialogService.confirm('Confirmar', '¿Estás seguro de que quieres borrar esta empresa?')
    .then((confirmed) => {
      if (confirmed) {
        this._empresas.deleteEmpresa(empresa).subscribe(data => {
          this.empresas = this.empresas.filter(v => v !== empresa);
        });
      }
    });
  }

}
