import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { EmpresaContacto } from 'src/app/modelos/empresa-contacto.model';
import { Empresa } from 'src/app/modelos/Empresa.model';
import { EmpresasContactosService } from 'src/app/servicios/empresas-contactos.service';

@Component({
  selector: 'app-add-empresa-contacto',
  templateUrl: './add-empresa-contacto.component.html',
  styleUrls: ['./add-empresa-contacto.component.css']
})
export class AddEmpresaContactoComponent implements OnInit {

  // Variables
  @Input() public empresa: Empresa;

  public empresaContactoForm: FormGroup;
  public empresaContacto: EmpresaContacto = new EmpresaContacto();

  constructor(
    private _empresasContactos: EmpresasContactosService,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
    // Creo el FormGroup
    this.empresaContactoForm = new FormGroup({
      empresa: new FormControl(this.empresa),
      tipo: new FormControl('', Validators.required),
      dato: new FormControl('', Validators.required)
    });
  }

  guardarEmpresaContacto() {
    this.empresaContacto = Object.assign({}, this.empresaContactoForm.value);
    console.log(this.empresaContacto);
    this._empresasContactos.addEmpresaContacto(this.empresaContacto).subscribe(data => {
      this.modalService.close();
    });
  }

}
