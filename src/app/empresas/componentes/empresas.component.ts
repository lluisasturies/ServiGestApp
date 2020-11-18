import { EmpresasService } from './../../servicios/empresas.service';
import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AddEmpresaComponent } from './add-empresa/add-empresa.component';
import { Empresa } from 'src/app/modelos/Empresa.model';

@Component({
  selector: 'app-empresas',
  templateUrl: './empresas.component.html',
  styleUrls: ['./empresas.component.css']
})
export class EmpresasComponent implements OnInit {

  // Variables
  public empresas: Empresa[];

  constructor(
    private _empresas: EmpresasService,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
    this.obtenerEmpresas();
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

}
