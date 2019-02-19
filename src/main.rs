mod mvc;
use mvc::*;

fn main() {
    println!("Running CASBoard");

    let mut model = model::Model::new();
    let mut view = view::View::new();
    let mut controller = Controller::new(model, view);

    controller.mainloop();

    println!("Exiting CASBoard");
}
