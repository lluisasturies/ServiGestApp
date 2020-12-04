import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Empresa } from 'src/app/modelos/Empresa.model';
import { EmpresasService } from 'src/app/servicios/empresas.service';

@Component({
  selector: 'app-add-empresa',
  templateUrl: './add-empresa.component.html',
  styleUrls: ['./add-empresa.component.css']
})
export class AddEmpresaComponent implements OnInit {

  // Variables
  public empresa: Empresa = new Empresa();
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
      nombreComercial: new FormControl('', Validators.required),
      nombreFiscal: new FormControl('', Validators.required),
      nif: new FormControl('', Validators.required),
      direccion: new FormControl('', Validators.required),
      localidad: new FormControl('', Validators.required),
      provincia: new FormControl('', Validators.required),
      prefijoOrdenes: new FormControl('', Validators.required)
    });
  }

  // Guardar Empresa
  guardarEmpresa() {
    this.empresa = Object.assign({}, this.empresaForm.value);

    this._empresas.addEmpresa(this.empresa).subscribe(data => {
      this.modalService.close();
    },
    (err: any) => {
      this.isFail = true;
      this.errorMsg = err.error.message;
    });
  }

}
