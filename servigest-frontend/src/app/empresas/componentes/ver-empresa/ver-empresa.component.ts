import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { EmpresaContacto } from 'src/app/modelos/empresa-contacto.model';
import { Empresa } from 'src/app/modelos/Empresa.model';
import { ConfirmationDialogService } from 'src/app/servicios/confirmation-dialog.service';
import { EmpresasContactosService } from 'src/app/servicios/empresas-contactos.service';
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
    private _empresaContactos: EmpresasContactosService,
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

  addEmpresa() {
    const modalRef = this.modalService.open(AddEmpresaContactoComponent);
    modalRef.componentInstance.cliente = this.empresa;
    modalRef.result.then((result) => {
      this.ngOnInit();
    });
  }

  // Borrar una linea de Empresa
  borrarContacto(empresaContacto: EmpresaContacto) {
    this.confirmationDialogService.confirm('Confirmar', '¿Estás seguro de que quieres borrar este contacto?')
    .then((confirmed) => {
      if (confirmed) {
        this._empresaContactos.deleteEmpresaContacto(empresaContacto).subscribe(data => {
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
