extern crate winit;

pub enum Event {
    Quit,
    Awakened,
    NoOp
}

pub struct View {
    winit_events_loop : winit::EventsLoop,
    winit_window: winit::Window
}

impl View {

    pub fn new()->View {
        let mut events_loop = winit::EventsLoop::new();
        let window_builder = winit::WindowBuilder::new()
        .with_title("CASBoard")
        .with_visibility(false);
        let winit_window = window_builder.build(&events_loop).unwrap();
        let view = View { winit_events_loop: events_loop, winit_window: winit_window };

        view
    }

    pub fn run_until_event(&mut self)->Event {
        let mut out_event : Event;
        self.winit_events_loop.run_forever(|event| {
            out_event = match event {
                winit::Event::WindowEvent {event, window_id} => self.handle_window_event(event),
                winit::Event::DeviceEvent {event, device_id} => self.handle_device_event(event),
                winit::Event::Awakened => Event::Awakened,
                _ => Event::NoOp
            };
            winit::ControlFlow::Break
        });
        out_event
    }

    fn handle_window_event(&mut self, event: winit::WindowEvent)->Event {
        if event == winit::WindowEvent::CloseRequested {
            return Event::Quit
        }
        Event::NoOp
    }

    fn handle_device_event(&mut self, event: winit::DeviceEvent)->Event {
        Event::NoOp
    }

    fn draw(&mut self) {

    }
}