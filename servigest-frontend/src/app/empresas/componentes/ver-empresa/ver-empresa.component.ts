import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { EmpresaContacto } from 'src/app/modelos/empresa-contacto.model';
import { EmpresaEmail } from 'src/app/modelos/empresa-email.model';
import { EmpresaTelefono } from 'src/app/modelos/empresa-telefono.model';
import { Empresa } from 'src/app/modelos/Empresa.model';
import { ConfirmationDialogService } from 'src/app/servicios/confirmation-dialog.service';
import { EmpresasContactosService } from 'src/app/servicios/empresas-contactos.service';
import { EmpresasEmailsService } from 'src/app/servicios/empresas-emails.service';
import { EmpresasTelefonosService } from 'src/app/servicios/empresas-telefonos.service';
import { EmpresasService } from 'src/app/servicios/empresas.service';
import { AddEmpresaContactoComponent } from '../add-empresa-contacto/add-empresa-contacto.component';
import { UpdateEmpresaComponent } from '../update-empresa/update-empresa.component';

@Component({
  selector: 'app-ver-empresa',
  templateUrl: './ver-empresa.component.html',
  styleUrls: ['./ver-empresa.component.css']
})
export class VerEmpresaComponent implements OnInit {
  
  // Variables
  empresa: Empresa = new Empresa();
  contactos: EmpresaContacto[];

  constructor(
    private _empresas: EmpresasService,
    private _empresasTelefonos: EmpresasTelefonosService,
    private _empresasEmails: EmpresasEmailsService,
    private route: ActivatedRoute,
    private confirmationDialogService: ConfirmationDialogService,
    private modalService: NgbModal,
    private router: Router
  ) { }

  ngOnInit(): void {
    const idEmpresa = this.route.snapshot.params.idEmpresa;

    this.obtenerEmpresa(idEmpresa);
  }

  // Obtener la Empresa
  obtenerEmpresa(idEmpresa: number): void {
    this._empresas.getEmpresa(idEmpresa).subscribe(data => {
      this.empresa = data; 
    });
  }

  addContacto() {
    const modalRef = this.modalService.open(AddEmpresaContactoComponent);
    modalRef.componentInstance.empresa = this.empresa;
    modalRef.result.then((result) => {
      this.ngOnInit();
    });
  }

  // Borrar un Telefono
  borrarTelefono(empresaTelefono: EmpresaTelefono) {
    this.confirmationDialogService.confirm('Confirmar', '¿Estás seguro de que quieres borrar este telefono?')
    .then((confirmed) => {
      if (confirmed) {
        this._empresasTelefonos.deleteEmpresaTelefono(empresaTelefono).subscribe(data => {
          this.ngOnInit();
        });
      }
    });
  }

  // Borrar un Email
  borrarEmail(empresaEmail: EmpresaEmail) {
    this.confirmationDialogService.confirm('Confirmar', '¿Estás seguro de que quieres borrar este email?')
    .then((confirmed) => {
      if (confirmed) {
        this._empresasEmails.deleteEmpresaEmail(empresaEmail).subscribe(data => {
          this.ngOnInit();
        });
      }
    });
  }

  // Modal Editar Empresa
  editarEmpresa() {
    const modalRef = this.modalService.open(UpdateEmpresaComponent);
    modalRef.componentInstance.empresa = this.empresa;
    modalRef.result.then((result) => {
      this.ngOnInit();
    });
  }

  // Borrar una Empresa
  borrarEmpresa() {
    this.confirmationDialogService.confirm('Confirmar', '¿Estás seguro de que quieres borrar esta empresa?')
    .then((confirmed) => {
      if (confirmed) {
        this._empresas.deleteEmpresa(this.empresa).subscribe(data => {
          this.router.navigate(['empresas']);
        });
      }
    });
  }

}
