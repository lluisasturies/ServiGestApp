import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { EmpresaEmail } from 'src/app/modelos/empresa-email.model';
import { EmpresaTelefono } from 'src/app/modelos/empresa-telefono.model';
import { Empresa } from 'src/app/modelos/Empresa.model';
import { EmpresasEmailsService } from 'src/app/servicios/empresas-emails.service';
import { EmpresasTelefonosService } from 'src/app/servicios/empresas-telefonos.service';

@Component({
  selector: 'app-add-empresa-contacto',
  templateUrl: './add-empresa-contacto.component.html',
  styleUrls: ['./add-empresa-contacto.component.css']
})
export class AddEmpresaContactoComponent implements OnInit {

  // Variables
  @Input() public empresa: Empresa;

  public empresaContactoForm: FormGroup;
  public empresaTelefono: EmpresaTelefono = new EmpresaTelefono();
  public empresaEmail: EmpresaEmail = new EmpresaEmail();
  public isFail = false;
  public errorMsg = '';

  constructor(
    private _empresasTelefonos: EmpresasTelefonosService,
    private _empresasEmails: EmpresasEmailsService,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
    // Creo el FormGroup
    this.empresaContactoForm = new FormGroup({
      empresa: new FormControl(this.empresa),
      tipo: new FormControl('', Validators.required),
      informacion: new FormControl('', Validators.required),
      dato: new FormControl('', Validators.required)
    });
  }

  guardarEmpresaContacto() {
    if (this.empresaContactoForm.controls.tipo.value == 'TELEFONO') {
      this.empresaTelefono.telefono = this.empresaContactoForm.controls.dato.value;
      this.empresaTelefono.informacion = this.empresaContactoForm.controls.informacion.value;
      this.empresaTelefono.empresa = this.empresaContactoForm.controls.empresa.value;

      this._empresasTelefonos.addEmpresaTelefono(this.empresaTelefono).subscribe(data => {
        this.modalService.close();
      },
      (err: any) => {
        this.isFail = true;
        this.errorMsg = err.error.message;
      });

    } else if (this.empresaContactoForm.controls.tipo.value == 'EMAIL') {
      this.empresaEmail.email = this.empresaContactoForm.controls.dato.value;
      this.empresaEmail.informacion = this.empresaContactoForm.controls.informacion.value;
      this.empresaEmail.empresa = this.empresaContactoForm.controls.empresa.value;

      console.log(this.empresaEmail);

      this._empresasEmails.addEmpresaEmail(this.empresaEmail).subscribe(data => {
        this.modalService.close();
      },
      (err: any) => {
        this.isFail = true;
        this.errorMsg = err.error.message;
      });
    }

  }

}
