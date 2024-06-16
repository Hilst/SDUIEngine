//
//  ContentView.swift
//  KMMSample
//
//  Created by Felipe Hilst on 16/06/24.
//

import SwiftUI

import SDUIEngine

struct ContentView: View {
	let engine = SDUIEngine()

    var body: some View {
        VStack {
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundStyle(.tint)
			Text("Hello, world! with fib of 10: \(engine.fibonacci(n: 10))")
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
