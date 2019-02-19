pub mod view;
pub mod model;

pub struct Controller {
    model : model::Model,
    view : view::View
}

impl Controller {
    pub fn new(model : model::Model, view : view::View)->Controller {
        Controller{model, view}
    }

    pub fn mainloop(&mut self) {
        loop {
            let event = self.view.run_until_event();
            if let view::Event::Quit = event {
                break;
            }
        }
    }
}