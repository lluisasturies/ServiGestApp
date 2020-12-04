import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Empresa } from 'src/app/modelos/Empresa.model';
import { EmpresasService } from 'src/app/servicios/empresas.service';

@Component({
  selector: 'app-update-empresa',
  templateUrl: './update-empresa.component.html',
  styleUrls: ['./update-empresa.component.css']
})
export class UpdateEmpresaComponent implements OnInit {

  // Variables
  @Input() empresa: Empresa;

  public empresaForm: FormGroup;
  public isFail = false;
  public errorMsg = '';

  constructor(
    private _empresas: EmpresasService,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
    // Creo el FormGroup
    this.empresaForm = new FormGroup({
      idEmpresa: new FormControl(this.empresa.idEmpresa),
      nombreComercial: new FormControl(this.empresa.nombreComercial, Validators.required),
      nombreFiscal: new FormControl(this.empresa.nombreFiscal, Validators.required),
      nif: new FormControl(this.empresa.nif, Validators.required),
      direccion: new FormControl(this.empresa.direccion, Validators.required),
      localidad: new FormControl(this.empresa.localidad, Validators.required),
      provincia: new FormControl(this.empresa.provincia, Validators.required),
      prefijoOrdenes: new FormControl(this.empresa.prefijoOrdenes, Validators.required)
    });
  }

  // Actualizar la Empresa
  actualizarEmpresa() {
    this.empresa = Object.assign({}, this.empresaForm.value);

    this._empresas.updateEmpresa(this.empresa).subscribe(data => {
      this.modalService.close();
    },
    (err: any) => {
      this.isFail = true;
      this.errorMsg = err.error.message;
    });
  }

}
