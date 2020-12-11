import { Component, OnInit, Input } from '@angular/core';

// Servicios
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Cliente } from 'src/app/modelos/Cliente.model';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ClienteTelefono } from 'src/app/modelos/cliente-telefono.model';
import { ClienteEmail } from 'src/app/modelos/cliente-email.model';
import { ClientesTelefonosService } from 'src/app/servicios/clientes-telefonos.service';
import { ClientesEmailsService } from 'src/app/servicios/clientes-emails.service';

@Component({
  selector: 'app-add-contacto',
  templateUrl: './add-contacto.component.html',
  styleUrls: ['./add-contacto.component.css']
})
export class AddContactoComponent implements OnInit {

  // Variables
  @Input() public cliente: Cliente;

  public clienteContactoForm: FormGroup;
  public clienteTelefono: ClienteTelefono = new ClienteTelefono();
  public clienteEmail: ClienteEmail = new ClienteEmail();
  public isFail = false;
  public errorMsg = '';

  constructor(
    private _clientesTelefonos: ClientesTelefonosService,
    private _clientesEmails: ClientesEmailsService,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
    // Creo el FormGroup
    this.clienteContactoForm = new FormGroup({
      cliente: new FormControl(this.cliente),
      tipo: new FormControl('', Validators.required),
      informacion: new FormControl(''),
      dato: new FormControl('', Validators.required)
    });
  }

  guardarClienteContacto() {
    if (this.clienteContactoForm.controls.tipo.value == 'TELEFONO') {
      this.clienteTelefono.telefono = this.clienteContactoForm.controls.dato.value;
      this.clienteTelefono.informacion = this.clienteContactoForm.controls.informacion.value;
      this.clienteTelefono.cliente = this.clienteContactoForm.controls.cliente.value;

      this._clientesTelefonos.addClienteTelefono(this.clienteTelefono).subscribe(data => {
        this.modalService.close();
      },
      (err: any) => {
        this.isFail = true;
        this.errorMsg = err.error.message;
      });

    } else if (this.clienteContactoForm.controls.tipo.value == 'EMAIL') {
      this.clienteEmail.email = this.clienteContactoForm.controls.dato.value;
      this.clienteEmail.informacion = this.clienteContactoForm.controls.informacion.value;
      this.clienteEmail.cliente = this.clienteContactoForm.controls.cliente.value;

      this._clientesEmails.addClienteEmail(this.clienteEmail).subscribe(data => {
        this.modalService.close();
      },
      (err: any) => {
        this.isFail = true;
        this.errorMsg = err.error.message;
      });
    }
    
  }

}
