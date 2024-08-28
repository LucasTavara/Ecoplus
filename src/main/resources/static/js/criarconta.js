class UserSubmit {
    constructor(settings) {
        this.settings = settings;
        this.form = document.querySelector(settings.form);
        this.formButton = document.querySelector(settings.button);
        if (this.form) {
            this.url = this.form.getAttribute("action");
        }
        this.sendForm = this.sendForm.bind(this);
    }

    displaySuccess() {
        this.form.innerHTML = this.settings.success;
    }

    displayError() {
        this.form.innerHTML = this.settings.error;
    }

    getFormObject() {
        const formObject = {};
        const fields = this.form.querySelectorAll("[name]");
        fields.forEach((field) => {
            formObject[field.getAttribute("name")] = field.value;
        });
        return formObject;
    }

    onSubmission(event) {
        event.preventDefault();
        event.target.disabled = true;
        event.target.innerText = "Enviando...";
    }

    async sendForm(event) {
        try {
            this.onSubmission(event);
            const response = await fetch(this.url, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                    Accept: "application/json",
                },
                body: JSON.stringify(this.getFormObject()),
            });
            if (response.ok) {
                this.displaySuccess();
                setTimeout(() => {
                    window.location.href = this.settings.redirectUrl;
                }, 2000); 
            } else {
                this.displayError();
            }
        } catch (error) {
            this.displayError();
            console.error("Erro ao enviar o formulário:", error);
        }
    }

    init() {
        if (this.form) this.formButton.addEventListener("click", this.sendForm);
        return this;
    }
}

document.addEventListener("DOMContentLoaded", () => {
    const userSubmit = new UserSubmit({
        form: "#registerForm",
        button: "button[type='submit']",
        success: "<h1 class='success'>Usuário criado com sucesso!</h1>",
        error: "<h1 class='error'>Não foi possível criar o usuário.</h1>",
        redirectUrl: "/"
    });

    userSubmit.init();
});
