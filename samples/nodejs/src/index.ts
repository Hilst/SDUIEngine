import { SDUIEngineJS } from "kmm-sdui";

const halo = 'Hello World'
const engine = new SDUIEngineJS()

function uppercase(input: string): string {
    return input.toUpperCase()
}

function fibonacciOfLen(input: string, sdui: SDUIEngineJS): number {
    const l = input.length
    const f = sdui.fib(l)
    return f
}

console.log(uppercase(halo))
console.log(fibonacciOfLen(halo, engine))


console.log("#====================#")

engine.consoleLogFib(5)